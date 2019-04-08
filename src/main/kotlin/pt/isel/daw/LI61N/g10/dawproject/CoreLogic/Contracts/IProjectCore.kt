package pt.isel.daw.LI61N.g10.dawproject.CoreLogic.Contracts

import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.AuthIM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.ProjectIM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.ProjectOM
import pt.isel.daw.LI61N.g10.dawproject.Helpers.ReturningData

interface IProjectCore {

    fun createProject(proj :ProjectIM) : ReturningData<ProjectOM>

    fun changeProject(id :Int, proj: ProjectIM) : ReturningData<ProjectOM>

    fun deleteProject(id: Int) : ReturningData<ProjectOM>

    fun getProjects(): ReturningData<Collection<ProjectOM>>

    fun getProject(id: Int): ReturningData<ProjectOM>
}