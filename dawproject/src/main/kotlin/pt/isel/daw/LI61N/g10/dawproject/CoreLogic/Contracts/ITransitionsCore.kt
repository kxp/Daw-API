package pt.isel.daw.LI61N.g10.dawproject.CoreLogic.Contracts

import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.AuthIM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.TransitionsIM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.TransitionsOM
import pt.isel.daw.LI61N.g10.dawproject.Helpers.ReturningData

interface ITransitionsCore {
    fun CreateTransition(authIM : AuthIM, proj : TransitionsIM) : ReturningData<TransitionsOM>

    fun ChangeTransition(authIM : AuthIM, proj: TransitionsIM) : ReturningData<TransitionsOM>

    fun DeleteTransition(authIM : AuthIM, id: Int) : ReturningData<TransitionsOM>

    fun Getransitions(authIM : AuthIM, id:Int): ReturningData<Collection<TransitionsOM>>
}