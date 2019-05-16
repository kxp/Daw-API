package pt.isel.daw.LI61N.g10.dawproject.DataAccess.Contracts

import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Models.AssocIssueLabel

interface IAssocIssueLabelDataAccess {

    fun createAssocIssueLabel(assocIssueLabel: AssocIssueLabel): AssocIssueLabel?

    fun getAllAssocIssueLabelByIssueID(issue_number: Int): Collection<AssocIssueLabel>?

    fun deleteAssocIssueLabel(label_id: Int, issue_number: Int): Int
}