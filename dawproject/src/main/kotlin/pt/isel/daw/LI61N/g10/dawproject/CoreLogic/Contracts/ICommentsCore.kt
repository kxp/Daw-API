package pt.isel.daw.LI61N.g10.dawproject.CoreLogic.Contracts

import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.AuthIM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.CommentsIM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.CommentsOM
import pt.isel.daw.LI61N.g10.dawproject.Helpers.ReturningData

interface ICommentsCore {
    fun CreateComment(authIM : AuthIM, proj :CommentsIM) : ReturningData<CommentsOM>

    fun ChangeComment(authIM : AuthIM, proj: CommentsIM) :ReturningData<CommentsOM>

    fun DeleteComment(authIM : AuthIM, id: Int)

    fun GetComments(authIM : AuthIM): ReturningData<Iterable<CommentsOM>>
}