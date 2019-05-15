package pt.isel.daw.LI61N.g10.dawproject.Controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.LabelIM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.LabelOM
import pt.isel.daw.LI61N.g10.dawproject.CoreLogic.Contracts.ILabelsCore
import pt.isel.daw.LI61N.g10.dawproject.Helpers.MessageCode

@RestController
@RequestMapping("/v1/projects/{project_id}/labels/")
class LabelsController {

    @Autowired
    private val labelsCore: ILabelsCore? = null

    @PostMapping
    @ResponseBody
    fun createLabel(@RequestBody label: LabelIM): ResponseEntity<Any> {
        var returningData = labelsCore!!.createLabel(label)
        var labelReceived = returningData.Data
        if(returningData.MessageCode == MessageCode.Ok && returningData.Data != null){
            return ResponseEntity.ok(labelReceived!!)
        }
        return ResponseEntity.status(500).body("Couldn't create the project") //todo change error message
    }

    @GetMapping
    @ResponseBody
    fun getAllLabels(@PathVariable project_id: Int): ResponseEntity<Collection<LabelOM>> {
        val returningData = labelsCore!!.getLabels(project_id)
        if(returningData.MessageCode == MessageCode.Ok && returningData.Data != null){
            return ResponseEntity.ok(returningData.Data!!)
        }
        return ResponseEntity.notFound().build<Collection<LabelOM>>()
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    fun deleteLabel(@PathVariable id: Int): ResponseEntity<Any> {
        val messageCode = labelsCore!!.deleteLabel(id).MessageCode
        if(messageCode == MessageCode.Ok)
        {
            return ResponseEntity.ok().build()
        }
        return ResponseEntity.notFound().build()
    }
}