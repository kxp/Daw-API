package pt.isel.daw.LI61N.g10.dawproject.DataAccess.Contracts

import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Models.State

public interface IProjectStatesDataAccess {

    fun getProjectStates(id: Int?): Iterable<State>?

    fun deleteProjectStates(id: Int?)

    fun createProjectStates(states: Iterable<State>?)
}