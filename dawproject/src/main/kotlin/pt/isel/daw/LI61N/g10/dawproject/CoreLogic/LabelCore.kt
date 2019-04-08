package pt.isel.daw.LI61N.g10.dawproject.CoreLogic

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.AuthIM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.LabelsIM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.LabelsOM
import pt.isel.daw.LI61N.g10.dawproject.CoreLogic.Contracts.ILabelsCore
import pt.isel.daw.LI61N.g10.dawproject.CoreLogic.UserValidation.Companion.Validate
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Contracts.ILabelDataAccess
import pt.isel.daw.LI61N.g10.dawproject.Helpers.MessageCode
import pt.isel.daw.LI61N.g10.dawproject.Helpers.ReturningData

@Service
class LabelCore : ILabelsCore {
    @Autowired
    private val labelRepository: ILabelDataAccess? = null

    override fun ChangeLabels(auth: AuthIM, projectID: Int, labelsIM: LabelsIM): ReturningData<Collection<LabelsOM>> {

        if (Validate(auth) == false){

            var returnResult = ReturningData<Collection<LabelsOM>>(MessageCode.InvalidCredentials, null )
            return returnResult
        }

        // var labels = labelRepository!!.getProjectStates(projectID)


        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun GetLabels(auth: AuthIM, projectID: Int): ReturningData<Collection<LabelsOM>> {


        if (Validate(auth) == false){

            var returnResult = ReturningData<Collection<LabelsOM>>(MessageCode.InvalidCredentials, null )
            return returnResult
        }
        /*var labels = labelRepository!!.getLabels(projectID)

        if (labels == null  || labels.isEmpty()== true)
        {
            var returnResult = ReturningData<Collection<LabelsOM>>(MessageCode.GenericError, null )
            return returnResult
        }

        //filling the Output model
        var cenas = mutableListOf<LabelsOM>()
        cenas.forEach{
            //cenas.add(LabelsOM(it.id,it.name , it.project_id ))
        }

        var returnResult = ReturningData<Collection<LabelsOM>>(MessageCode.GenericError, cenas)
        return returnResult*/


        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}