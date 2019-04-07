package pt.isel.daw.LI61N.g10.dawproject.DataAccess.Contracts

import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Models.Issue

interface IIssueDataAccess {

    fun getProjectIssue(issue_number: Int?): Issue?

    fun createProjectIssue(pet: Issue): Int

    fun getProjectIssues(project_id: Int?): Collection<Issue>?

    fun deleteIssue(id: Int?)
}