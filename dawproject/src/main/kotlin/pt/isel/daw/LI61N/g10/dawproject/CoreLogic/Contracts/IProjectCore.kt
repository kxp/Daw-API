package pt.isel.daw.LI61N.g10.dawproject.CoreLogic.Contracts

import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.AuthIM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.ProjectIM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.ProjectOM
import pt.isel.daw.LI61N.g10.dawproject.Helpers.ReturningData

interface IProjectCore {

    fun CreateProject(authIM : AuthIM, proj :ProjectIM) : ReturningData<ProjectOM>

    fun ChangeProject(authIM : AuthIM, id :Int, proj: ProjectIM) : ReturningData<ProjectOM>

    fun DeleteProject(authIM : AuthIM, id: Int) : ReturningData<ProjectOM>

    fun GetProjects(authIM : AuthIM): ReturningData<Collection<ProjectOM>>

}