package pt.isel.daw.LI61N.g10.dawproject.Controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.TransitionIM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.TransitionOM
import pt.isel.daw.LI61N.g10.dawproject.CoreLogic.Contracts.ITransitionsCore
import pt.isel.daw.LI61N.g10.dawproject.Helpers.MessageCode

@RestController
@RequestMapping("/v1/projects/{project_id}/transitions/")
class TransitionsController {

    @Autowired
    private val coreTransitions: ITransitionsCore? = null

    @PutMapping
    @ResponseBody
    fun updateTransitions(@PathVariable project_id: Int, @RequestBody states: List<TransitionIM>) : ResponseEntity<Any> {
        var returningData = coreTransitions!!.changeTransitions(project_id, states)

        var transitionsReceived = returningData.Data
        if(returningData.MessageCode == MessageCode.Ok && returningData.Data != null){
            return ResponseEntity.ok(transitionsReceived!!.toList())
        }
        return ResponseEntity.status(500).body("Couldn't update the states") //todo change error message
    }

    @DeleteMapping
    @ResponseBody
    fun deleteTransitions(@PathVariable project_id: Int) : ResponseEntity<Any>{
        val messageCode = coreTransitions!!.deleteTransitions(project_id).MessageCode
        if(messageCode == MessageCode.Ok)
        {
            return ResponseEntity.ok().build()
        }
        return ResponseEntity.notFound().build()
    }

    @GetMapping
    @ResponseBody
    fun getTransitions(@PathVariable project_id: Int): ResponseEntity<Collection<TransitionOM>> {
        val returningData = coreTransitions!!.getTransitions(project_id)
        var transitionsOM = returningData.Data
        if(returningData.MessageCode == MessageCode.Ok && returningData.Data != null){
            return ResponseEntity.ok(transitionsOM!!)
        }
        return ResponseEntity.notFound().build<Collection<TransitionOM>>()
    }
}