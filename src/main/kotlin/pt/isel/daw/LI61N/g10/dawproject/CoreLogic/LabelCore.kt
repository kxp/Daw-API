package pt.isel.daw.LI61N.g10.dawproject.CoreLogic

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.LabelIM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.LabelOM
import pt.isel.daw.LI61N.g10.dawproject.CoreLogic.Contracts.ILabelsCore
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Contracts.ILabelDataAccess
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Models.Label
import pt.isel.daw.LI61N.g10.dawproject.Helpers.MessageCode
import pt.isel.daw.LI61N.g10.dawproject.Helpers.ReturningData

@Service
class LabelCore : ILabelsCore {

    @Autowired
    private val labelRepository: ILabelDataAccess? = null

    override fun getLabels(projectID: Int): ReturningData<Collection<LabelOM>> {
        var labels = labelRepository!!.getLabelsByProjectID(projectID)

        if (labels != null)
        {
            //filling the Output model
            var labelList = mutableListOf<LabelOM>()
            labels.forEach{
                labelList.add(convertFromLabelToLabelOM(it))
            }
            return ReturningData<Collection<LabelOM>>(MessageCode.Ok, labelList)
        }
        return ReturningData<Collection<LabelOM>>(MessageCode.GenericError, null )
    }

    override fun createLabel(label: LabelIM): ReturningData<LabelOM> {
        var labelCreated = labelRepository!!.createLabel(Label(label.id, label.projectID, label.name))

        if(labelCreated != null){
            return ReturningData<LabelOM>(MessageCode.Ok, convertFromLabelToLabelOM(labelCreated))
        }
        else
        {
            return ReturningData<LabelOM>(MessageCode.GenericError, null)
        }
    }

    override fun deleteLabel(label_id: Int): ReturningData<LabelOM> {
        var deleted = labelRepository!!.deleteLabel(label_id)
        if(deleted > 0){
            return ReturningData<LabelOM>(MessageCode.Ok, null )
        }
        return ReturningData<LabelOM>(MessageCode.ProjectNotFound, null)
    }

    private fun convertFromLabelToLabelOM(label : Label) : LabelOM {
        return LabelOM(label.id, label.projectID, label.name)
    }
}