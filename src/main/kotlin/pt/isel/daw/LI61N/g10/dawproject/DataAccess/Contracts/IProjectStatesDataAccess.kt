package pt.isel.daw.LI61N.g10.dawproject.DataAccess.Contracts

import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Models.State

public interface IProjectStatesDataAccess {

    fun getProjectStates(id: Int?): Collection<State>?

    fun deleteProjectStates(id: Int?) : Int

    fun createProjectStates(project_id: Int, states: Collection<State>): Collection<State>?
}