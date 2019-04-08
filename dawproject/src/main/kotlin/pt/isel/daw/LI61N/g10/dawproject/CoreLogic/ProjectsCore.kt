package pt.isel.daw.LI61N.g10.dawproject.CoreLogic

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.AuthIM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.LabelsOM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.ProjectIM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.ProjectOM
import pt.isel.daw.LI61N.g10.dawproject.CoreLogic.Contracts.IProjectCore
import pt.isel.daw.LI61N.g10.dawproject.CoreLogic.UserValidation.Companion.Validate
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Contracts.IProjectDataAccess
import pt.isel.daw.LI61N.g10.dawproject.Helpers.MessageCode
import pt.isel.daw.LI61N.g10.dawproject.Helpers.ReturningData

@Service
class ProjectsCore : IProjectCore{



    @Autowired
    private val projectRepository: IProjectDataAccess? = null


    override fun CreateProject(auth: AuthIM, proj: ProjectIM): ReturningData<ProjectOM> {

        if (Validate(auth) == false){

            var returnResult = ReturningData<ProjectOM>(MessageCode.InvalidCredentials, null )
            return returnResult
        }
        //projectRepository!!.createProject()
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun ChangeProject(auth: AuthIM, id: Int, proj: ProjectIM): ReturningData<ProjectOM> {


        if (Validate(auth) == false){

            var returnResult = ReturningData<ProjectOM>(MessageCode.InvalidCredentials, null )
            return returnResult
        }
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun DeleteProject(auth: AuthIM, id: Int) : ReturningData<ProjectOM> {

        if (Validate(auth) == false){

            var returnResult = ReturningData<ProjectOM>(MessageCode.InvalidCredentials, null )
            return returnResult
        }

        projectRepository!!.deleteProject(id)
        return ReturningData<ProjectOM>(MessageCode.Ok, null )
    }

    override fun GetProjects(auth: AuthIM): ReturningData<Collection<ProjectOM>> {


        if (Validate(auth) == false){

            var returnResult = ReturningData<Collection<ProjectOM>>(MessageCode.InvalidCredentials, null )
            return returnResult
        }

        var projs = projectRepository!!.getProjects()

        if (projs == null  || projs.isEmpty()== true)
        {
            var returnResult = ReturningData<Collection<ProjectOM>>(MessageCode.GenericError, null )
            return returnResult
        }

        //filling the Output model
        var projectsList = mutableListOf<ProjectOM>()
        projs.forEach{
            projectsList.add(ProjectOM(it.id,it.name , it.short_desc ))
        }

        var returnResult = ReturningData<Collection<ProjectOM>>(MessageCode.Ok, projectsList)
        return returnResult
    }
}