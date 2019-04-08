package pt.isel.daw.LI61N.g10.dawproject.CoreLogic.Contracts

import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.AuthIM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.IssueIM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.IssueOM
import pt.isel.daw.LI61N.g10.dawproject.Helpers.ReturningData

interface IIssuesCore {
    fun CreateIssue(authIM : AuthIM, projectID :Int, issue :IssueIM) : ReturningData<IssueOM>

    fun ChangeIssue(authIM : AuthIM, projectID :Int, issue: IssueIM) : ReturningData<IssueOM>

    fun DeleteIssue(authIM : AuthIM, projectID :Int, id: Int) : ReturningData<IssueOM>

    fun GetIssues(authIM : AuthIM, projectID :Int): ReturningData<Collection<IssueOM>>
}