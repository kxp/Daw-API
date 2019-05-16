import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.AssocIssueLabelIM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.OutputModels.AssocIssueLabelOM
import pt.isel.daw.LI61N.g10.dawproject.CoreLogic.Contracts.IAssocIssueLabelCore
import pt.isel.daw.LI61N.g10.dawproject.Helpers.MessageCode

@RestController
@RequestMapping("/v1/projects/{project_id}/issues/{issue_id}/labels/") // todo path may be wrong
class AssocIssueLabelController {

    @Autowired
    private val assocIssueLabelCore: IAssocIssueLabelCore? = null

    @PostMapping
    @ResponseBody
    fun createLabel(@RequestBody assoc: AssocIssueLabelIM): ResponseEntity<Any> {
        var returningData = assocIssueLabelCore!!.createAssocIssueLabel(assoc)
        var assocReceived = returningData.Data
        if(returningData.MessageCode == MessageCode.Ok && returningData.Data != null){
            return ResponseEntity.ok(assocReceived!!)
        }
        return ResponseEntity.status(500).body("Couldn't create the project") //todo change error message
    }

    @GetMapping
    @ResponseBody
    fun getAllLabels(@PathVariable issue_id: Int): ResponseEntity<Collection<AssocIssueLabelOM>> {
        val returningData = assocIssueLabelCore!!.getAllAssocIssueLabelByIssueID(issue_id)
        if(returningData.MessageCode == MessageCode.Ok && returningData.Data != null){
            return ResponseEntity.ok(returningData.Data!!)
        }
        return ResponseEntity.notFound().build<Collection<AssocIssueLabelOM>>()
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    fun deleteLabel(@PathVariable id: Int, @PathVariable issue_id: Int): ResponseEntity<Any> {
        val messageCode = assocIssueLabelCore!!.deleteAssocIssueLabel(id, issue_id).MessageCode
        if(messageCode == MessageCode.Ok)
        {
            return ResponseEntity.ok().build()
        }
        return ResponseEntity.notFound().build()
    }
}