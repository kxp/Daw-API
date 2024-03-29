package pt.isel.daw.LI61N.g10.dawproject.CoreLogic

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.ProjectIM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.ProjectOM
import pt.isel.daw.LI61N.g10.dawproject.CoreLogic.Contracts.IProjectCore
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Contracts.IProjectDataAccess
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Models.Project
import pt.isel.daw.LI61N.g10.dawproject.Helpers.MessageCode
import pt.isel.daw.LI61N.g10.dawproject.Helpers.ReturningData

@Service
class ProjectsCore : IProjectCore{

    @Autowired
    private val projectRepository: IProjectDataAccess? = null


    override fun createProject(proj: ProjectIM): ReturningData<ProjectOM> {
        var project = projectRepository!!.createProject(Project(proj.id, proj.name, proj.short_desc))

        if(project != null){
            return ReturningData<ProjectOM>(MessageCode.Ok, ProjectOM(project.id, project.name, project.short_desc))
        }
        else
        {
            return ReturningData<ProjectOM>(MessageCode.GenericError, null)
        }
    }

    override fun changeProject(id: Int, proj: ProjectIM): ReturningData<ProjectOM> {

        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteProject(id: Int) : ReturningData<ProjectOM> {
        var deleted = projectRepository!!.deleteProject(id)
        if(deleted > 0){
            return ReturningData<ProjectOM>(MessageCode.Ok, null )
        }
        return ReturningData<ProjectOM>(MessageCode.ProjectNotFound, null)
    }

    override fun getProjects(): ReturningData<Collection<ProjectOM>> {
        var projects = projectRepository!!.getProjects()

        if (projects != null)
        {
            //filling the Output model
            var projectsList = mutableListOf<ProjectOM>()
            projects.forEach{
                projectsList.add(ProjectOM(it.id,it.name , it.short_desc ))
            }
            return ReturningData<Collection<ProjectOM>>(MessageCode.Ok, projectsList)
        }
        return ReturningData<Collection<ProjectOM>>(MessageCode.GenericError, null )
    }

    override fun getProject(id: Int): ReturningData<ProjectOM> {
        val project = projectRepository!!.getProject(id)
        if(project!=null)
        {
            return ReturningData<ProjectOM>(MessageCode.Ok, ProjectOM(project.id, project.name, project.short_desc))
        }
        return ReturningData<ProjectOM>(MessageCode.ProjectNotFound, null )
    }
}