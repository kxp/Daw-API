package pt.isel.daw.LI61N.g10.dawproject.CoreLogic.Contracts

import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.Auth
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.Comments

interface ICommentsCore {
    fun CreateComment(auth : Auth, proj :Comments)

    fun ChangeComment(auth : Auth, proj: Comments)

    fun DeleteComment(auth : Auth, id: Int)

    fun GetComments(auth : Auth): List<Comments>
}