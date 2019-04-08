package pt.isel.daw.LI61N.g10.dawproject.CoreLogic

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.AuthIM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.IssueIM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.IssueOM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.ProjectOM
import pt.isel.daw.LI61N.g10.dawproject.CoreLogic.Contracts.IIssuesCore
import pt.isel.daw.LI61N.g10.dawproject.CoreLogic.UserValidation.Companion.Validate
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Contracts.IIssueDataAccess
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Models.Issue
import pt.isel.daw.LI61N.g10.dawproject.Helpers.MessageCode
import pt.isel.daw.LI61N.g10.dawproject.Helpers.ReturningData
import java.time.LocalDateTime
import java.util.*

@Service
class IssuesCore : IIssuesCore {

    @Autowired
    private val issueRepository: IIssueDataAccess? = null

    override fun CreateIssue(auth: AuthIM, projectID: Int, issue: IssueIM): ReturningData<IssueOM> {


        if (Validate(auth) == false){

            var returnResult = ReturningData<IssueOM>(MessageCode.InvalidCredentials, null )
            return returnResult
        }


        //var issue = Issue(issue.id, issue.name, issue.short_desc, Date.from()  , -1, -1, projectID)
        //issueRepository!!.createProjectIssue()
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun ChangeIssue(auth: AuthIM, projectID: Int, issue: IssueIM): ReturningData<IssueOM> {

        if (Validate(auth) == false){

            var returnResult = ReturningData<IssueOM>(MessageCode.InvalidCredentials, null )
            return returnResult
        }

        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun DeleteIssue(auth: AuthIM, projectID: Int, id: Int) : ReturningData<IssueOM> {

        if (Validate(auth) == false){

            var returnResult = ReturningData<IssueOM>(MessageCode.InvalidCredentials, null )
            return returnResult
        }

       issueRepository!!.deleteIssue(id)

        return  ReturningData<IssueOM>(MessageCode.Ok, null )

        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun GetIssues(auth: AuthIM, projectID: Int): ReturningData<Collection<IssueOM>> {

        if (Validate(auth) == false){

            var returnResult = ReturningData<Collection<IssueOM>>(MessageCode.InvalidCredentials, null )
            return returnResult
        }

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

        var returnResult = ReturningData<Collection<IssueOM>>(MessageCode.Ok, issuesList)
        return returnResult
    }

}