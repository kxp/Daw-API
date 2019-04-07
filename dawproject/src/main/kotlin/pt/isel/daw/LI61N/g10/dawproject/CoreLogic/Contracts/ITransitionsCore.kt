package pt.isel.daw.LI61N.g10.dawproject.CoreLogic.Contracts

import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.AuthIM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.TransitionsIM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.TransitionsOM

interface ITransitionsCore {
    fun CreateTransition(authIM : AuthIM, proj : TransitionsIM) : TransitionsOM

    fun ChangeTransition(authIM : AuthIM, proj: TransitionsIM) : TransitionsOM

    fun DeleteTransition(authIM : AuthIM, id: Int)

    fun Getransitions(authIM : AuthIM): Iterable<TransitionsOM>
}