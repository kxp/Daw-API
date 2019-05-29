package pt.isel.daw.LI61N.g10.dawproject.CoreLogic.Contracts

import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.AssocIssueLabelIM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.OutputModels.AssocIssueLabelOM
import pt.isel.daw.LI61N.g10.dawproject.Helpers.ReturningData

interface IAssocIssueLabelCore {
    fun getAllAssocIssueLabelByIssueID(issueID :Int): ReturningData<Collection<AssocIssueLabelOM>>

    fun createAssocIssueLabel(assocIssueLabelIM: AssocIssueLabelIM) : ReturningData<AssocIssueLabelOM>

    fun deleteAssocIssueLabel(label_id: Int, issue_number: Int) : ReturningData<AssocIssueLabelOM>
}