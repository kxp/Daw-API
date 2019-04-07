package pt.isel.daw.LI61N.g10.dawproject.CoreLogic.Contracts

import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.Auth
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.Project

interface IProjectCore {

    fun CreateProject(auth : Auth, proj :Project)

    fun ChangeProject(auth : Auth, id :Int, proj: Project)

    fun DeleteProject(auth : Auth, id: Int)

    fun GetProjects(auth : Auth): List<Project>

}