package pt.isel.daw.LI61N.g10.dawproject.CoreLogic

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.CommentIM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.CommentOM
import pt.isel.daw.LI61N.g10.dawproject.CoreLogic.Contracts.ICommentsCore
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Contracts.ICommentDataAccess
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Models.Comment
import pt.isel.daw.LI61N.g10.dawproject.Helpers.MessageCode
import pt.isel.daw.LI61N.g10.dawproject.Helpers.ReturningData
import pt.isel.daw.LI61N.g10.dawproject.Helpers.TimeConverter
import java.time.LocalDateTime

@Service
class CommentsCore :ICommentsCore{

    @Autowired
    private val commentsRepository: ICommentDataAccess? = null

    override fun createComment(issueID: Int, comment: CommentIM): ReturningData<CommentOM> {
        var addedComment= commentsRepository!!.createComment(Comment(
                comment.id,
                comment.text,
                comment.issueID,
                TimeConverter.convertToDateViaInstant(LocalDateTime.now())
        ))

        if (addedComment != null && comment.issueID == issueID){
            return  ReturningData<CommentOM>(MessageCode.Ok, convertCommentToCommentOM(addedComment))
        }

        return  ReturningData<CommentOM>(MessageCode.GenericError, null )
    }

    override fun deleteComment(commentID: Int): ReturningData<CommentOM> {
        var deleted = commentsRepository!!.deleteComment(commentID)
        if(deleted > 0){
            return ReturningData<CommentOM>(MessageCode.Ok, null )
        }
        return ReturningData<CommentOM>(MessageCode.ProjectNotFound, null)
    }

    override fun getComments(issueID: Int): ReturningData<Collection<CommentOM>> {
        var comments = commentsRepository!!.getCommentsByIssueID(issueID)

        if(comments != null)
        {
            //filling the Output model
            var commentsList = mutableListOf<CommentOM>()
            comments.forEach{
                commentsList.add(convertCommentToCommentOM(it))
            }
            return ReturningData<Collection<CommentOM>>(MessageCode.Ok, commentsList)
        }
        return ReturningData<Collection<CommentOM>>(MessageCode.GenericError, null )
    }

    private fun convertCommentToCommentOM(comment: Comment): CommentOM{
        return CommentOM(comment.id, comment.short_text, comment.issue_id, comment.creationDate)
    }
}