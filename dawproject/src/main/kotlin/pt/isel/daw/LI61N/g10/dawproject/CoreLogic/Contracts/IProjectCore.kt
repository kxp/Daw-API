package pt.isel.daw.LI61N.g10.dawproject.CoreLogic.Contracts
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.ProjectIM

interface IProjectCore {
    interface IProjectDataAccess {

        fun CreateProject(proj :ProjectIM)

        fun ChangeProject(proj: ProjectIM)

        fun DeleteProject( id: Int)

        fun GetProjects(): List<ProjectIM>
    }
}