package pt.isel.daw.LI61N.g10.dawproject.CoreLogic

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.StateIM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.StateOM
import pt.isel.daw.LI61N.g10.dawproject.CoreLogic.Contracts.IStatesCore
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Contracts.IProjectStatesDataAccess
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Models.State
import pt.isel.daw.LI61N.g10.dawproject.Helpers.MessageCode
import pt.isel.daw.LI61N.g10.dawproject.Helpers.ReturningData

@Service
class StatesCore :IStatesCore {

    @Autowired
    private val stateRepository: IProjectStatesDataAccess? = null

    override fun ChangeProjectStates(states: Collection<StateIM>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

        stateRepository!!.createProjectStates(states.map {state-> State(state.id, state.name, state.projectID) })
    }

    override fun getProjectStates(project_id: Int): ReturningData<Collection<StateOM>>? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.


        var states = stateRepository!!.getProjectStates(project_id)

        if (states == null  || states.isEmpty() == true)
        {
            var returnResult = ReturningData<Collection<StateOM>>(MessageCode.GenericError, null )
            return returnResult
        }

        //filling the Output model
        var statesOM = mutableListOf<StateOM>()
        states.forEach{
            statesOM.add(StateOM(it.id,it.name, it.project_id ))
        }

        return ReturningData<Collection<StateOM>>(MessageCode.Ok, statesOM)
    }

    override fun deleteProjectStates(project_id: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        stateRepository!!.deleteProjectStates(project_id)
    }
}