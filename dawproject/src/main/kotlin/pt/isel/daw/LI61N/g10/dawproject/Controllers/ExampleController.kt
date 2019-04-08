package pt.isel.daw.LI61N.g10.dawproject.Controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.AuthIM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.StateOM
import pt.isel.daw.LI61N.g10.dawproject.CoreLogic.Contracts.IStatesCore
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Contracts.IIssueDataAccess
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Contracts.IProjectStatesDataAccess
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Models.Issue
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Models.State
import pt.isel.daw.LI61N.g10.dawproject.Helpers.MessageCode
import java.util.*

// A container for handlers TODO: DELETE THIS!
@RestController
@RequestMapping("/v1/projects/")
class ExampleController {


    /********************* ISSUES *******************/

    @Autowired
    private val issueRepository: IIssueDataAccess? = null


    @PostMapping("/{project_id}/issues/")
    @ResponseBody
    fun createIssue(@RequestBody issue: Issue): String {
        issueRepository!!.createProjectIssue(issue)
        return String.format("Added %s", issue)
    }

    @GetMapping("/{project_id}/issues/")
    @ResponseBody
    fun getAllIssues(@PathVariable project_id: Int?): Iterable<Issue>? {
        return issueRepository!!.getProjectIssues(project_id)
    }

    @GetMapping("/{project_id}/issues/{issue_id}")
    @ResponseBody
    fun getIssue(@PathVariable issue_id: Int?): Optional<Issue> {
        return Optional.ofNullable(issueRepository!!.getProjectIssue(issue_id))
    }

    @DeleteMapping("/{project_id}/issues/{issue_id}")
    @ResponseBody
    fun deleteIssue(@PathVariable issue_id: Int?): String {
        issueRepository!!.deleteIssue(issue_id)
        return "Deleted " + issue_id!!
    }

}