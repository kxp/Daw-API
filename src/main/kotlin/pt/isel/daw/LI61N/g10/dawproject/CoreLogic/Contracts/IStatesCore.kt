package pt.isel.daw.LI61N.g10.dawproject.CoreLogic.Contracts

import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.StateIM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.StateOM
import pt.isel.daw.LI61N.g10.dawproject.Helpers.ReturningData

interface IStatesCore {
    fun changeProjectStates(project_id: Int, states: Collection<String>) : ReturningData<Collection<StateOM>>

    fun getProjectStates(project_id: Int): ReturningData<Collection<StateOM>>

    fun deleteProjectStates(project_id: Int) : ReturningData<StateOM>
}