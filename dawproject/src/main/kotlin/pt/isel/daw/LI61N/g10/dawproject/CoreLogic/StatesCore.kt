package pt.isel.daw.LI61N.g10.dawproject.CoreLogic

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.AuthIM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.StatesIM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.StatesOM
import pt.isel.daw.LI61N.g10.dawproject.CoreLogic.Contracts.IStatesCore
import pt.isel.daw.LI61N.g10.dawproject.CoreLogic.UserValidation.Companion.Validate
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Contracts.IProjectStatesDataAccess
import pt.isel.daw.LI61N.g10.dawproject.Helpers.MessageCode
import pt.isel.daw.LI61N.g10.dawproject.Helpers.ReturningData

@Service
class StatesCore :IStatesCore {


    @Autowired
    private val stateRepository: IProjectStatesDataAccess? = null

    override fun ChangeStates(auth: AuthIM, projectID: Int, labels: StatesIM): ReturningData<Collection<StatesOM>> {

        if (Validate(auth) == false){

            var returnResult = ReturningData<Collection<StatesOM>>(MessageCode.InvalidCredentials, null )
            return returnResult
        }
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun GetStates(auth: AuthIM, projectID: Int): ReturningData<Collection<StatesOM>> {

        if (Validate(auth) == false){

            var returnResult = ReturningData<Collection<StatesOM>>(MessageCode.InvalidCredentials, null )
            return returnResult
        }

        var states = stateRepository!!.getProjectStates(projectID)

        if (states == null  || states.isEmpty() == true)
        {
            var returnResult = ReturningData<Collection<StatesOM>>(MessageCode.GenericError, null )
            return returnResult
        }

        //filling the Output model
        var cenas = mutableListOf<StatesOM>()
        states.forEach{
            cenas.add(StatesOM(it.id,it.name, it.project_id ))
        }

        var returnResult = ReturningData<Collection<StatesOM>>(MessageCode.Ok, cenas)
        return returnResult

    }
}