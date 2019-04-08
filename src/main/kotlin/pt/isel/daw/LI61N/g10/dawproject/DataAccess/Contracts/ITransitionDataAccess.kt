package pt.isel.daw.LI61N.g10.dawproject.DataAccess.Contracts

import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Models.Transition

interface ITransitionDataAccess {

    fun createTransition(transition: Transition): Int

    fun getProjectStateTransitions(project_id: Int?): Collection<Transition>?

    fun deleteTransition(transition: Transition)
}