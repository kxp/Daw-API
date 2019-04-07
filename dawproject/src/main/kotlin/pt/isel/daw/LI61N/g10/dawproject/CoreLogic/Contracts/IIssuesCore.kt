package pt.isel.daw.LI61N.g10.dawproject.CoreLogic.Contracts

import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.Auth
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.Issue

interface IIssuesCore {
    fun CreateIssue(auth : Auth, projectID :Int, issue :Issue)

    fun ChangeIssue(auth : Auth, projectID :Int, issue: Issue)

    fun DeleteIssue(auth : Auth, projectID :Int, id: Int)

    fun GetIssues(auth : Auth, projectID :Int): List<Issue>
}