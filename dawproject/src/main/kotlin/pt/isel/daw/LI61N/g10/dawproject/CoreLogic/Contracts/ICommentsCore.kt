package pt.isel.daw.LI61N.g10.dawproject.CoreLogic.Contracts

import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.AuthIM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.CommentsIM

interface ICommentsCore {
    fun CreateComment(authIM : AuthIM, proj :CommentsIM)

    fun ChangeComment(authIM : AuthIM, proj: CommentsIM)

    fun DeleteComment(authIM : AuthIM, id: Int)

    fun GetComments(authIM : AuthIM): Iterable<CommentsIM>
}