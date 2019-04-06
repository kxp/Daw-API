package pt.isel.daw.LI61N.g10.dawproject.DataAccess.Contracts

interface IProjectDataAccess {

    fun CreateProject(var Project proj)

    fun ChangeProject(var Project proj)

    fun DeleteProject(var id: Int)

    fun GetProjects(): List<Projects>
}