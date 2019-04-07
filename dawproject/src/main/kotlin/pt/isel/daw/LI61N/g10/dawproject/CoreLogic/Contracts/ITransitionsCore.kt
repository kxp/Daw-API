package pt.isel.daw.LI61N.g10.dawproject.CoreLogic.Contracts

import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.AuthIM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.TransitionsIM

interface ITransitionsCore {
    fun CreateTransition(authIM : AuthIM, proj : TransitionsIM)

    fun ChangeTransition(authIM : AuthIM, proj: TransitionsIM)

    fun DeleteTransition(authIM : AuthIM, id: Int)

    fun Getransitions(authIM : AuthIM): List<TransitionsIM>
}