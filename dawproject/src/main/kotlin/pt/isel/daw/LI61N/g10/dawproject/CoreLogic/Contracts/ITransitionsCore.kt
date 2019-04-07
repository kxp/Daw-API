package pt.isel.daw.LI61N.g10.dawproject.CoreLogic.Contracts

import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.Auth
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.Transitions

interface ITransitionsCore {
    fun CreateTransition(auth : Auth, proj : Transitions)

    fun ChangeTransition(auth : Auth, proj: Transitions)

    fun DeleteTransition(auth : Auth, id: Int)

    fun Getransitions(auth : Auth): List<Transitions>
}