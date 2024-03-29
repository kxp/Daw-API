package pt.isel.daw.LI61N.g10.dawproject.Controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.ProjectIM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.ProjectOM
import pt.isel.daw.LI61N.g10.dawproject.CoreLogic.Contracts.IProjectCore
import pt.isel.daw.LI61N.g10.dawproject.Helpers.MessageCode

@RestController
@RequestMapping("/v1/projects/")
class ProjectController {

    @Autowired
    private val projectsCore: IProjectCore? = null

    @PostMapping
    @ResponseBody
    fun createProject(@RequestBody project: ProjectIM): ResponseEntity<Any> {
        var returningData = projectsCore!!.createProject(project)
        var project_received = returningData.Data
        if(returningData.MessageCode == MessageCode.Ok && returningData.Data != null){
            return ResponseEntity.ok(project_received!!)
        }
        return ResponseEntity.status(500).body("Couldn't create the project") //todo change error message
    }

    @GetMapping
    @ResponseBody
    fun getAllProjects(): ResponseEntity<Collection<ProjectOM>> {
        val returningData = projectsCore!!.getProjects()
        if(returningData.MessageCode == MessageCode.Ok && returningData.Data != null){
            return ResponseEntity.ok(returningData.Data!!)
        }
        return ResponseEntity.notFound().build<Collection<ProjectOM>>()
    }

    @GetMapping("/{id}")
    @ResponseBody
    fun getProject(@PathVariable id: Int): ResponseEntity<ProjectOM> {
        val returningData= projectsCore!!.getProject(id)
        if(returningData.MessageCode == MessageCode.Ok && returningData.Data != null){
            val project = returningData.Data
            if(project != null)
            {
                return ResponseEntity.ok(project)
            }
        }
        return ResponseEntity.notFound().build<ProjectOM>()
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    fun deleteProject(@PathVariable id: Int): ResponseEntity<Any> {
        val messageCode = projectsCore!!.deleteProject(id).MessageCode
        if(messageCode == MessageCode.Ok)
        {
            return ResponseEntity.ok().build()
        }
        return ResponseEntity.notFound().build()
    }
}