package pt.isel.daw.LI61N.g10.dawproject.Controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Contracts.IProjectDataAccess
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Contracts.IProjectStatesDataAccess
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Models.Project
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Models.State
import java.util.*

// A container for handlers TODO: DELETE THIS!
@RestController
@RequestMapping("/v1/projects/")
class ExampleController {

    @Autowired
    private val projectRepository: IProjectDataAccess? = null

    /********************* PROJECTS *******************/
    @PostMapping
    @ResponseBody
    fun createPet(@RequestBody project: Project): String {
        projectRepository!!.createProject(project)
        return String.format("Added %s", project)
    }

    @GetMapping
    @ResponseBody
    fun getAllProjects(): Iterable<Project> {
        return projectRepository!!.getProjects()
    }

    @GetMapping("/{id}")
    @ResponseBody
    fun getProject(@PathVariable id: Int?): Optional<Project> {
        return Optional.ofNullable(projectRepository!!.getProject(id))
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    fun deleteProject(@PathVariable id: Int?): String {
        projectRepository!!.deleteProject(id)
        return "Deleted " + id!!
    }


    /************ STATES *************/

    @Autowired
    private val stateRepository: IProjectStatesDataAccess? = null

    @PutMapping("/{project_id}/states/")
    @ResponseBody
    fun updateStates(
            @PathVariable project_id: Int,
            @RequestBody states: List<State>
            ): String {
        stateRepository!!.createProjectStates(states)
        return String.format("Added states to project: %s, states: %s", project_id, states)
    }

    @DeleteMapping("/{project_id}/states/")
    @ResponseBody
    fun deleteProjectStates(@PathVariable project_id: Int?): String {
        stateRepository!!.deleteProjectStates(project_id)
        return "Deleted states of the project " + project_id!!
    }

    @GetMapping("/{project_id}/states/")
    @ResponseBody
    fun getAllProjectStates(@PathVariable project_id: Int?): Iterable<State>? {
        return stateRepository!!.getProjectStates(project_id)
    }

}