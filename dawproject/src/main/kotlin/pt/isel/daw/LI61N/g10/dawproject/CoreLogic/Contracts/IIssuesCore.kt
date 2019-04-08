package pt.isel.daw.LI61N.g10.dawproject.CoreLogic.Contracts

import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.AuthIM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.IssueIM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.IssueOM
import pt.isel.daw.LI61N.g10.dawproject.Helpers.ReturningData

interface IIssuesCore {
    fun createIssue(issue :IssueIM) : ReturningData<IssueOM>

    fun changeIssue(issue: IssueIM) : ReturningData<IssueOM>

    fun deleteIssue(issue_id: Int) : ReturningData<IssueOM>

    fun getProjectIssues(projectID :Int): ReturningData<Collection<IssueOM>>
}