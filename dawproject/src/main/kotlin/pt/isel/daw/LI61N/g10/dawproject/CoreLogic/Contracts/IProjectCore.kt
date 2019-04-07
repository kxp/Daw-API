package pt.isel.daw.LI61N.g10.dawproject.CoreLogic.Contracts

import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.AuthIM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.ProjectIM

interface IProjectCore {

    fun CreateProject(authIM : AuthIM, proj :ProjectIM)

    fun ChangeProject(authIM : AuthIM, id :Int, proj: ProjectIM)

    fun DeleteProject(authIM : AuthIM, id: Int)

    fun GetProjects(authIM : AuthIM): List<ProjectIM>

}