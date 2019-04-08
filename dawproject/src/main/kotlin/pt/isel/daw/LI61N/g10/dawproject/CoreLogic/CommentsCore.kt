package pt.isel.daw.LI61N.g10.dawproject.CoreLogic

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.CommentsIM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.CommentsOM
import pt.isel.daw.LI61N.g10.dawproject.CoreLogic.Contracts.ICommentsCore
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Contracts.ICommentDataAccess
import pt.isel.daw.LI61N.g10.dawproject.Helpers.ReturningData

@Service
class CommentsCore :ICommentsCore{

    @Autowired
    private val commentsRepository: ICommentDataAccess? = null



    override fun CreateComment(comment: CommentsIM): ReturningData<CommentsOM> {


        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun ChangeComment(comment: CommentsIM): ReturningData<CommentsOM> {


        //get current info to iupdate only the changes
        //commentsRepository!!.

        //commentsRepository!!.updateComment(comment)

        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun DeleteComment(project: Int, issueID : Int, commentID :Int): ReturningData<CommentsOM> {

        //commentsRepository.deleteComment(id)
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun GetComments(id:Int): ReturningData<Collection<CommentsOM>> {


/*
        var comments = commentsRepository!!.getComments(id)

        if (comments == null  || comments.isEmpty()== true)
        {
            var returnResult = ReturningData<Collection<CommentsOM>>(MessageCode.GenericError, null )
            return returnResult
        }

        //filling the Output model
        var commentsList = mutableListOf<CommentsOM>()
        comments.forEach{
            commentsList.add(CommentsOM(it.id ,it.short_text , it.issue_id ))
        }

        var returnResult = ReturningData<Collection<CommentsOM>>(MessageCode.Ok, commentsList)
        return returnResult*/

        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}