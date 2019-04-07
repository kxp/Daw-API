package pt.isel.daw.LI61N.g10.dawproject.DataAccess.Contracts

import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Models.Project

interface IProjectDataAccess {

    fun getProject(id: Int?): Project?

    fun createProject(pet: Project): Int

    fun getProjects(): Iterable<Project>

    fun deleteProject(id: Int?)
}