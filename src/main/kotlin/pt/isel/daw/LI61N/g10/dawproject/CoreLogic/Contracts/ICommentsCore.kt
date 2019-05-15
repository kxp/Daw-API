package pt.isel.daw.LI61N.g10.dawproject.CoreLogic.Contracts

import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.CommentIM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.CommentOM
import pt.isel.daw.LI61N.g10.dawproject.Helpers.ReturningData

interface ICommentsCore {
    fun createComment(issueID: Int, comment: CommentIM): ReturningData<CommentOM>

    //fun changeComment(comment: CommentIM) :ReturningData<CommentOM>

    fun deleteComment(commentID: Int): ReturningData<CommentOM>

    fun getComments(issueID: Int): ReturningData<Collection<CommentOM>>
}