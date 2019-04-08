package pt.isel.daw.LI61N.g10.dawproject.CoreLogic.Contracts

import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.AuthIM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.TransitionsIM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.TransitionsOM
import pt.isel.daw.LI61N.g10.dawproject.Helpers.ReturningData

interface ITransitionsCore {
    fun CreateTransition(proj : TransitionsIM) : ReturningData<TransitionsOM>

    fun ChangeTransition(proj: TransitionsIM) : ReturningData<TransitionsOM>

    fun DeleteTransition(id: Int) : ReturningData<TransitionsOM>

    fun Getransitions(id:Int): ReturningData<Collection<TransitionsOM>>
}