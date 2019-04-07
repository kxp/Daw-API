package pt.isel.daw.LI61N.g10.dawproject.DataAccess.Contracts

import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Models.AssocIssueLabel

interface IAssocIssueLabelDataAccess {

    fun AddLabelToIssue(assocIssueLabel: AssocIssueLabel): Int

    fun getIssueLabels(issue_number: Int?): Iterable<AssocIssueLabel>?

    fun deleteIssueLabel(assocIssueLabel: AssocIssueLabel)
}