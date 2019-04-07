package pt.isel.daw.LI61N.g10.dawproject.Controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.beans.factory.annotation.Autowired
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Contracts.IProjectDataAccess
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Models.Project
import java.util.*

// A container for handlers TODO: DELETE THIS!
@RestController
@RequestMapping("/v1/projects/")
class ExampleController {

    @Autowired
    private val projectRepository: IProjectDataAccess? = null

    @PostMapping
    @ResponseBody
    fun createPet(@RequestBody pet: Project): String {
        projectRepository!!.createProject(pet)
        return String.format("Added %s", pet)
    }

    @GetMapping
    @ResponseBody
    fun getAllPets(): Iterable<Project> {
        return projectRepository!!.getProjects()
    }

    @GetMapping("/{id}")
    @ResponseBody
    fun getPet(@PathVariable id: Int?): Optional<Project> {
        return Optional.ofNullable(projectRepository!!.getProject(id))
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    fun deletePet(@PathVariable id: Int?): String {
        projectRepository!!.deleteProject(id)
        return "Deleted " + id!!
    }
}