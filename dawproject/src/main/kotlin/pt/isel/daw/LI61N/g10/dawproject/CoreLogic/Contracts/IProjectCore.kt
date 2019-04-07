package pt.isel.daw.LI61N.g10.dawproject.CoreLogic.Contracts

import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.AuthIM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.ProjectIM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.ProjectOM

interface IProjectCore {

    fun CreateProject(authIM : AuthIM, proj :ProjectIM) : ProjectOM

    fun ChangeProject(authIM : AuthIM, id :Int, proj: ProjectIM) : ProjectOM

    fun DeleteProject(authIM : AuthIM, id: Int)

    fun GetProjects(authIM : AuthIM): Iterable<ProjectOM>

}