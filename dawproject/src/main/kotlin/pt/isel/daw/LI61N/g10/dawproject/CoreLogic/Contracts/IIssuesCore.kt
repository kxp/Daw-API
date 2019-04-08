package pt.isel.daw.LI61N.g10.dawproject.CoreLogic.Contracts

import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.AuthIM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.IssueIM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.IssueOM
import pt.isel.daw.LI61N.g10.dawproject.Helpers.ReturningData

interface IIssuesCore {
    fun CreateIssue(projectID :Int, issue :IssueIM) : ReturningData<IssueOM>

    fun ChangeIssue(projectID :Int, issue: IssueIM) : ReturningData<IssueOM>

    fun DeleteIssue(projectID :Int, id: Int) : ReturningData<IssueOM>

    fun GetIssues(projectID :Int): ReturningData<Collection<IssueOM>>
}