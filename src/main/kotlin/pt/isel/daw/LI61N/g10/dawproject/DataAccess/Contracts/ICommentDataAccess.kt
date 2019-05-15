package pt.isel.daw.LI61N.g10.dawproject.DataAccess.Contracts

import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Models.Comment

interface ICommentDataAccess {

    fun updateComment(comment: Comment): Int

    fun createComment(comment: Comment): Comment?

    fun getCommentsByIssueID(issueID: Int): Collection<Comment>

    fun deleteComment(id: Int?): Int
}