package pt.isel.daw.LI61N.g10.dawproject.Controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.StateOM
import pt.isel.daw.LI61N.g10.dawproject.CoreLogic.Contracts.IStatesCore
import pt.isel.daw.LI61N.g10.dawproject.Helpers.MessageCode

@RestController
@RequestMapping("/v1/projects/{project_id}/states/")
class StatesController {

    @Autowired
    private val coreState: IStatesCore? = null

    @PutMapping
    @ResponseBody
    fun updateStates(@PathVariable project_id: Int, @RequestBody states: List<String>) : ResponseEntity<Any> {
        var returningData = coreState!!.changeProjectStates(project_id, states)

        var statesReceived = returningData.Data
        if(returningData.MessageCode == MessageCode.Ok && returningData.Data != null){
            return ResponseEntity.ok(statesReceived!!.toList())
        }
        return ResponseEntity.status(500).body("Couldn't update the states") //todo change error message
    }

    @DeleteMapping
    @ResponseBody
    fun deleteProjectStates(@PathVariable project_id: Int) : ResponseEntity<Any>{
        val messageCode = coreState!!.deleteProjectStates(project_id).MessageCode
        if(messageCode == MessageCode.Ok)
        {
            return ResponseEntity.ok().build()
        }
        return ResponseEntity.notFound().build()
    }

    @GetMapping
    @ResponseBody
    fun getAllProjectStates(@PathVariable project_id: Int): ResponseEntity<Collection<StateOM>> {
        val returningData = coreState!!.getProjectStates(project_id)
        var statesOM = returningData.Data
        if(returningData.MessageCode == MessageCode.Ok && returningData.Data != null){
            return ResponseEntity.ok(statesOM!!)
        }
        return ResponseEntity.notFound().build<Collection<StateOM>>()
    }
}