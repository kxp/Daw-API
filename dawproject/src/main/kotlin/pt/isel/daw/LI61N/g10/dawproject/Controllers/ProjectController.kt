package pt.isel.daw.LI61N.g10.dawproject.Controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.ProjectIM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.ProjectOM
import pt.isel.daw.LI61N.g10.dawproject.CoreLogic.Contracts.IProjectCore

@RestController
@RequestMapping("/v1/projects/")
class ProjectController {

    @Autowired
    private val projectsCore: IProjectCore? = null

    @PostMapping
    @ResponseBody
    fun createProject(@RequestBody project: ProjectIM): ResponseEntity<ProjectOM> {
        projectsCore!!.createProject(project)
        return ResponseEntity.ok(ProjectOM(project.id, project.name, project.short_desc))
    }

    @GetMapping
    @ResponseBody
    fun getAllProjects(): ResponseEntity<Collection<ProjectOM>> {
        val projects = projectsCore!!.getProjects()
        val projectsOM = projects.Data!!.map {prj->ProjectOM(prj.id, prj.name, prj.shortDesc)}
        if(projectsOM.isNotEmpty()){
            return ResponseEntity.ok(projectsOM)
        }
        return ResponseEntity.notFound().build<Collection<ProjectOM>>()
    }

    @GetMapping("/{id}")
    @ResponseBody
    fun getProject(@PathVariable id: Int): ResponseEntity<ProjectOM> {
        val project = projectsCore!!.getProject(id).Data
        if(project != null)
        {
            return ResponseEntity.ok(project)
        }
        return ResponseEntity.notFound().build<ProjectOM>()
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    fun deleteProject(@PathVariable id: Int): ResponseEntity<ProjectOM> {
        val project = projectsCore!!.deleteProject(id).Data
        if(project != null)
        {
            return ResponseEntity.ok(project)
        }
        return ResponseEntity.notFound().build<ProjectOM>()
    }
}