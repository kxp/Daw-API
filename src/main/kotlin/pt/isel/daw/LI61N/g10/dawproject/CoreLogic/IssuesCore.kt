package pt.isel.daw.LI61N.g10.dawproject.CoreLogic

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.IssueIM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.IssueOM
import pt.isel.daw.LI61N.g10.dawproject.CoreLogic.Contracts.IIssuesCore
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Contracts.IIssueDataAccess
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Models.Issue
import pt.isel.daw.LI61N.g10.dawproject.Helpers.MessageCode
import pt.isel.daw.LI61N.g10.dawproject.Helpers.ReturningData
import java.time.LocalDateTime
import pt.isel.daw.LI61N.g10.dawproject.Helpers.TimeConverter

@Service
class IssuesCore : IIssuesCore {


    @Autowired
    private val issueRepository: IIssueDataAccess? = null

    override fun createIssue(projectID: Int, issue: IssueIM): ReturningData<IssueOM> {
        var addedIssue = issueRepository!!.createProjectIssue(Issue(
                issue.number,
                issue.name,
                issue.short_desc,
                TimeConverter.convertToDateViaInstant(LocalDateTime.now()),
                null,
                issue.stateID,
                projectID))

        if (addedIssue != null ){
            return  ReturningData<IssueOM>(MessageCode.Ok, convertIssueToIssueOM(addedIssue))
        }

        return  ReturningData<IssueOM>(MessageCode.GenericError, null )
    }

    override fun changeIssue(projectID: Int, issue: IssueIM): ReturningData<IssueOM> {

        if (projectID != issue.projectID){
            return  ReturningData<IssueOM>(MessageCode.WrongProjectID, null )
        }

        var requestedIssue = issueRepository!!.getProjectIssue(issue.number)

        if (requestedIssue == null ){
            return  ReturningData<IssueOM>(MessageCode.IssueNotFound, null )
        }

        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteIssue(projectID: Int, id: Int) : ReturningData<IssueOM> {
        var deleted = issueRepository!!.deleteIssue(id)
        if(deleted > 0){
            return ReturningData<IssueOM>(MessageCode.Ok, null )
        }
        return ReturningData<IssueOM>(MessageCode.ProjectNotFound, null)
    }

    override fun getProjectIssue(project_id: Int, issue_number: Int): ReturningData<IssueOM> {
        var issue = issueRepository!!.getProjectIssue(issue_number)

        if (issue == null )
        {
            return ReturningData<IssueOM>(MessageCode.IssueNotFound, null )
        }
        if (issue.project_id != project_id){
            return ReturningData<IssueOM>(MessageCode.WrongProjectID, null )
        }
        return ReturningData<IssueOM>(MessageCode.Ok, convertIssueToIssueOM(issue))
    }

    override fun getProjectIssues(projectID: Int): ReturningData<Collection<IssueOM>> {
        var issues = issueRepository!!.getProjectIssues(projectID)

        if(issues != null)
        {
            //filling the Output model
            var issuesList = mutableListOf<IssueOM>()
            issues.forEach{
                issuesList.add(convertIssueToIssueOM(it))
            }
            return ReturningData<Collection<IssueOM>>(MessageCode.Ok, issuesList)
        }
        return ReturningData<Collection<IssueOM>>(MessageCode.GenericError, null )
    }

    fun convertIssueToIssueOM(issue: Issue) : IssueOM
    {
        return IssueOM(issue.state_id ,issue.name , issue.short_desc, issue.creation_date, issue.close_date, issue.state_id, issue.project_id )
    }
}