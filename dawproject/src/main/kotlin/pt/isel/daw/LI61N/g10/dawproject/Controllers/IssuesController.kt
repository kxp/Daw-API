package pt.isel.daw.LI61N.g10.dawproject.Controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.IssueIM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.IssueOM
import pt.isel.daw.LI61N.g10.dawproject.CoreLogic.Contracts.IIssuesCore

@RestController
@RequestMapping("/v1/projects/{project_id}/issues/")
class IssuesController {

    @Autowired
    private val issuesCore: IIssuesCore? = null

    @PostMapping
    @ResponseBody
    fun createIssue(@RequestBody issue: IssueIM, @PathVariable project_id: Int): ResponseEntity<IssueOM> {
        issuesCore!!.createIssue(project_id, issue)
        return ResponseEntity.ok(IssueOM(issue.id, issue.name, issue.short_desc, issue.creationDate, issue.closeDate, issue.stateID, issue.projectID))
    }

    @GetMapping
    @ResponseBody
    fun getAllIssues(@PathVariable project_id: Int): ResponseEntity<Collection<IssueOM>> {
        val issues = issuesCore!!.getProjectIssues(project_id)
        val issuesOM = issues.Data!!.map {issue->IssueOM(issue.id, issue.name, issue.short_desc, issue.creationDate, issue.closeDate, issue.stateID, issue.projectID)}
        if(issuesOM.isNotEmpty()){
            return ResponseEntity.ok(issuesOM)
        }
        return ResponseEntity.notFound().build<Collection<IssueOM>>()
    }

    @GetMapping("/{issue_id}/")
    @ResponseBody
    fun getIssue(@PathVariable issue_id: Int, @PathVariable project_id: Int): ResponseEntity<IssueOM> {
        val issue = issuesCore!!.getProjectIssue(project_id, issue_id).Data
        if(issue != null)
        {
            return ResponseEntity.ok(issue)
        }
        return ResponseEntity.notFound().build<IssueOM>()
    }

    @DeleteMapping("/{issue_id}/")
    @ResponseBody
    fun deleteIssue(@PathVariable project_id: Int, @PathVariable issue_id: Int): ResponseEntity<IssueOM> {
        val issue = issuesCore!!.deleteIssue(project_id, issue_id).Data
        if(issue != null)
        {
            return ResponseEntity.ok(issue)
        }
        return ResponseEntity.notFound().build<IssueOM>()
    }
}