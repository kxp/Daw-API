package pt.isel.daw.LI61N.g10.dawproject.CoreLogic.Contracts

import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.AuthIM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.CommentsIM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.CommentsOM
import pt.isel.daw.LI61N.g10.dawproject.Helpers.ReturningData

interface ICommentsCore {
    fun CreateComment(authIM : AuthIM, proj :CommentsIM) : ReturningData<CommentsOM>

    fun ChangeComment(authIM : AuthIM, proj: CommentsIM) :ReturningData<CommentsOM>

    fun DeleteComment(authIM : AuthIM, projectID : Int, issueID: Int, id: Int):ReturningData<CommentsOM>

    fun GetComments(authIM : AuthIM, id :Int): ReturningData<Collection<CommentsOM>>
}