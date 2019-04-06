package pt.isel.daw.LI61N.g10.dawproject.CoreLogic.Contracts
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.Project

interface IProjectCore {
    interface IProjectDataAccess {

        fun CreateProject(proj :Project)

        fun ChangeProject(proj: Project)

        fun DeleteProject( id: Int)

        fun GetProjects(): List<Project>
    }
}