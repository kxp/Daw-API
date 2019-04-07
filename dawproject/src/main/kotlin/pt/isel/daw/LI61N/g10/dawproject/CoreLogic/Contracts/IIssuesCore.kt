package pt.isel.daw.LI61N.g10.dawproject.CoreLogic.Contracts

import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.AuthIM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.IssueIM

interface IIssuesCore {
    fun CreateIssue(authIM : AuthIM, projectID :Int, issue :IssueIM)

    fun ChangeIssue(authIM : AuthIM, projectID :Int, issue: IssueIM)

    fun DeleteIssue(authIM : AuthIM, projectID :Int, id: Int)

    fun GetIssues(authIM : AuthIM, projectID :Int): Iterable<IssueIM>
}