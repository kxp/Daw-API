package pt.isel.daw.LI61N.g10.dawproject.DataAccess.Contracts

import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Models.Project

interface IProjectDataAccess {

    fun getProject(id: Int?): Project?

    fun createProject(project: Project): Project?

    fun getProjects(): Collection<Project>

    fun deleteProject(id: Int?): Int
}