package pt.isel.daw.LI61N.g10.dawproject.Controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.StateIM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.StateOM
import pt.isel.daw.LI61N.g10.dawproject.CoreLogic.Contracts.IStatesCore

@RestController
@RequestMapping("/v1/projects/{project_id}/states/")
class StatesController {

    @Autowired
    private val coreState: IStatesCore? = null

    @PutMapping
    @ResponseBody
    fun updateStates(
            @PathVariable project_id: Int,
            @RequestBody states: List<StateIM>
    ) {
        coreState!!.ChangeProjectStates(states)
        ResponseEntity.status(200)
    }

    @DeleteMapping
    @ResponseBody
    fun deleteProjectStates(@PathVariable project_id: Int) {
        coreState!!.deleteProjectStates(project_id)
        ResponseEntity.status(200)
    }

    @GetMapping
    @ResponseBody
    fun getAllProjectStates(@PathVariable project_id: Int): ResponseEntity<Collection<StateOM>>? {
        val states = coreState!!.getProjectStates(project_id)
        val statesOM = states!!.Data!!.map {state->StateOM(state.id, state.name, state.projectID)}
        if(statesOM.isNotEmpty()){
            return ResponseEntity.ok(statesOM)
        }
        return ResponseEntity.notFound().build<Collection<StateOM>>()
    }
}