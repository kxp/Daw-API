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

        val currentTime = LocalDateTime.now()
        var issue = Issue(-1, issue.name, issue.short_desc, TimeConverter. convertToDateViaInstant(currentTime)  , TimeConverter.convertToDateViaInstant(currentTime) , issue.stateID, projectID)
        var addedId = issueRepository!!.createProjectIssue(issue)

        var addedIssue = issueRepository!!.getProjectIssue(addedId)

        if (addedIssue == null ){
            return  ReturningData<IssueOM>(MessageCode.GenericError, null )
        }

        return  ReturningData<IssueOM>(MessageCode.Ok, IssueOM(addedIssue.state_id, addedIssue.name, addedIssue.short_desc, addedIssue.creation_date, addedIssue.close_date, addedIssue.state_id, addedIssue.project_id ))
    }

    override fun changeIssue(projectID: Int, issue: IssueIM): ReturningData<IssueOM> {

        if (projectID != issue.projectID){
            return  ReturningData<IssueOM>(MessageCode.WrongProjectID, null )
        }

        var requestedIssue = issueRepository!!.getProjectIssue(issue.id)

        if (requestedIssue == null ){
            return  ReturningData<IssueOM>(MessageCode.IssueNotFound, null )
        }

        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteIssue(projectID: Int, id: Int) : ReturningData<IssueOM> {

        var requestedIssue = issueRepository!!.getProjectIssue(id)

        if (requestedIssue == null ){
            return  ReturningData<IssueOM>(MessageCode.IssueNotFound, null )
        }

       issueRepository!!.deleteIssue(id)
        return  ReturningData<IssueOM>(MessageCode.Ok, null )
    }

    override fun getProjectIssue(project_id: Int, issue_number: Int): ReturningData<IssueOM> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getProjectIssues(projectID: Int): ReturningData<Collection<IssueOM>> {

       return getInternalIssues(projectID)
    }


    private fun getInternalIssues(projectID :Int) :  ReturningData<Collection<IssueOM>>{

        var issues = issueRepository!!.getProjectIssues(projectID)

        if (issues == null  || issues.isEmpty()== true)
        {
            var returnResult = ReturningData<Collection<IssueOM>>(MessageCode.GenericError, null )
            return returnResult
        }
        //filling the Output model
        var issuesList = mutableListOf<IssueOM>()
        issues.forEach{
            issuesList.add(IssueOM(it.state_id ,it.name , it.short_desc, it.creation_date, it.close_date, it.state_id, it.project_id ))
        }

        return ReturningData<Collection<IssueOM>>(MessageCode.Ok, issuesList)
    }

}