package pt.isel.daw.LI61N.g10.dawproject.DataAccess.Contracts

import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Models.Project

interface IProjectDataAccess {

    fun CreateProject(proj :Project)

    fun ChangeProject(proj: Project)

    fun DeleteProject( id: Int)

    fun GetProjects(): List<Project>
}