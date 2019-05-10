package pt.isel.daw.LI61N.g10.dawproject.Controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.IssueIM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.IssueOM
import pt.isel.daw.LI61N.g10.dawproject.CoreLogic.Contracts.IIssuesCore
import pt.isel.daw.LI61N.g10.dawproject.Helpers.MessageCode
import pt.isel.daw.LI61N.g10.dawproject.Helpers.TimeConverter
import java.time.LocalDate
import java.time.LocalDateTime

@RestController
@RequestMapping("/v1/projects/{project_id}/issues/")
class IssuesController {

    @Autowired
    private val issuesCore: IIssuesCore? = null

    @PostMapping
    @ResponseBody
    fun createIssue(@RequestBody issue: IssueIM, @PathVariable project_id: Int): ResponseEntity<Any> {
        var returningData =issuesCore!!.createIssue(project_id, issue)
        var issueReceived = returningData.Data
        if(returningData.MessageCode == MessageCode.Ok && issueReceived != null){
            return ResponseEntity.ok(IssueOM(issueReceived.number, issueReceived.name, issueReceived.short_desc, issueReceived.creationDate, issueReceived.closeDate, issue.stateID, issue.projectID))
        }
        return ResponseEntity.status(500).body("Couldn't create the project") //todo change error message
    }

    @GetMapping
    @ResponseBody
    fun getAllIssues(@PathVariable project_id: Int): ResponseEntity<Collection<IssueOM>> {
        val returningData = issuesCore!!.getProjectIssues(project_id)
        if(returningData.MessageCode == MessageCode.Ok && returningData.Data != null) {
            val issuesOM = returningData.Data!!.map { issue -> IssueOM(issue.number, issue.name, issue.short_desc, issue.creationDate, issue.closeDate, issue.stateID, issue.projectID) }
            return ResponseEntity.ok(issuesOM)
        }
        return ResponseEntity.notFound().build<Collection<IssueOM>>()
    }

    @GetMapping("/{issue_id}/")
    @ResponseBody
    fun getIssue(@PathVariable issue_id: Int, @PathVariable project_id: Int): ResponseEntity<IssueOM> {
        val returningData = issuesCore!!.getProjectIssue(project_id, issue_id)
        if(returningData.MessageCode == MessageCode.Ok && returningData.Data != null) {
            val issue = returningData.Data
            if (issue != null) {
                return ResponseEntity.ok(issue)
            }
        }
        return ResponseEntity.notFound().build<IssueOM>()
    }

    @DeleteMapping("/{issue_id}/")
    fun deleteIssue(@PathVariable project_id: Int, @PathVariable issue_id: Int) : ResponseEntity<Any>{
        val messageCode = issuesCore!!.deleteIssue(project_id, issue_id).MessageCode
        if(messageCode == MessageCode.Ok)
        {
            return ResponseEntity.ok().build()
        }
        return ResponseEntity.notFound().build()
    }
}