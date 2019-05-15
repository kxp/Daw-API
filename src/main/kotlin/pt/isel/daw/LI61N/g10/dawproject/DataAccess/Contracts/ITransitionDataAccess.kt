package pt.isel.daw.LI61N.g10.dawproject.DataAccess.Contracts

import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Models.Transition

interface ITransitionDataAccess {

    fun getProjectTransitions(project_id: Int?): Collection<Transition>?

    fun deleteProjectTransitions(project_id: Int): Int

    fun createProjectTransitions(project_id: Int, transitions: Collection<Transition>): Collection<Transition>?
}