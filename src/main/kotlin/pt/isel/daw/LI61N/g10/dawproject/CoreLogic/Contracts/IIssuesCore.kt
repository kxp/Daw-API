package pt.isel.daw.LI61N.g10.dawproject.CoreLogic.Contracts

import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.AuthIM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.IssueIM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.IssueOM
import pt.isel.daw.LI61N.g10.dawproject.Helpers.ReturningData

interface IIssuesCore {
    fun createIssue(project_id: Int, issue :IssueIM) : ReturningData<IssueOM>

    fun changeIssue(project_id: Int, issue: IssueIM) : ReturningData<IssueOM>

    fun deleteIssue(project_id: Int, issue_id: Int) : ReturningData<IssueOM>

    fun getProjectIssues(projectID :Int): ReturningData<Collection<IssueOM>>

    fun getProjectIssue(project_id: Int, issue_number: Int): ReturningData<IssueOM>
}