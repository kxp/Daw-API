package pt.isel.daw.LI61N.g10.dawproject.CoreLogic.Contracts

import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.TransitionIM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.TransitionOM
import pt.isel.daw.LI61N.g10.dawproject.Helpers.ReturningData

interface ITransitionsCore {
    //fun createTransition(proj : TransitionIM) : ReturningData<TransitionOM>

    fun changeTransitions(project_id: Int, transitions: Collection<TransitionIM>) : ReturningData<Collection<TransitionOM>>

    fun deleteTransitions(project_id: Int) : ReturningData<TransitionOM>

    fun getTransitions(project_id:Int): ReturningData<Collection<TransitionOM>>
}