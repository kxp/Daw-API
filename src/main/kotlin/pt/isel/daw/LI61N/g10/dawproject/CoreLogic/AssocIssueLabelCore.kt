package pt.isel.daw.LI61N.g10.dawproject.CoreLogic

import org.springframework.beans.factory.annotation.Autowired
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.AssocIssueLabelIM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.OutputModels.AssocIssueLabelOM
import pt.isel.daw.LI61N.g10.dawproject.CoreLogic.Contracts.IAssocIssueLabelCore
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Contracts.IAssocIssueLabelDataAccess
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Models.AssocIssueLabel
import pt.isel.daw.LI61N.g10.dawproject.Helpers.MessageCode
import pt.isel.daw.LI61N.g10.dawproject.Helpers.ReturningData

class AssocIssueLabelCore: IAssocIssueLabelCore {

    @Autowired
    private val assocRepository: IAssocIssueLabelDataAccess? = null

    override fun getAllAssocIssueLabelByIssueID(issueID: Int): ReturningData<Collection<AssocIssueLabelOM>> {
        var assocsReceived = assocRepository!!.getAllAssocIssueLabelByIssueID(issueID)

        if (assocsReceived != null)
        {
            //filling the Output model
            var labelList = mutableListOf<AssocIssueLabelOM>()
            assocsReceived.forEach{
                labelList.add(convertFromAssocIssueLabelToAssocIssueLabelOM(it))
            }
            return ReturningData<Collection<AssocIssueLabelOM>>(MessageCode.Ok, labelList)
        }
        return ReturningData<Collection<AssocIssueLabelOM>>(MessageCode.GenericError, null )
    }

    override fun createAssocIssueLabel(assocIssueLabelIM: AssocIssueLabelIM): ReturningData<AssocIssueLabelOM> {
        var assocReceived = assocRepository!!.createAssocIssueLabel(AssocIssueLabel(assocIssueLabelIM.label_id, assocIssueLabelIM.issue_number))

        if(assocReceived != null){
            return ReturningData<AssocIssueLabelOM>(MessageCode.Ok, convertFromAssocIssueLabelToAssocIssueLabelOM(assocReceived))
        }
        else
        {
            return ReturningData<AssocIssueLabelOM>(MessageCode.GenericError, null)
        }
    }

    override fun deleteAssocIssueLabel(label_id: Int, issue_number: Int): ReturningData<AssocIssueLabelOM> {
        var deleted = assocRepository!!.deleteAssocIssueLabel(label_id, issue_number)
        if(deleted > 0){
            return ReturningData<AssocIssueLabelOM>(MessageCode.Ok, null )
        }
        return ReturningData<AssocIssueLabelOM>(MessageCode.GenericError, null)
    }

    private fun convertFromAssocIssueLabelToAssocIssueLabelOM(assoc : AssocIssueLabel) : AssocIssueLabelOM {
        return AssocIssueLabelOM(assoc.label_id, assoc.issue_number)
    }
}