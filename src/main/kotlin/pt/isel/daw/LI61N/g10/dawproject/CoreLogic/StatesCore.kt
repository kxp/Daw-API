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

    override fun ChangeProjectStates(project_id: Int, states: Collection<String>) : ReturningData<Collection<StateOM>> {
        var statesToRet = stateRepository!!.createProjectStates(project_id, states.map {state-> State(1, state, project_id) })

        if(statesToRet != null){
            return ReturningData<Collection<StateOM>>(MessageCode.Ok, statesToRet.map { state -> StateOM(state.id, state.name, state.project_id) })
        }
        return ReturningData<Collection<StateOM>>(MessageCode.GenericError, null)
    }

    override fun getProjectStates(project_id: Int): ReturningData<Collection<StateOM>> {
        var states = stateRepository!!.getProjectStates(project_id)

        if(states != null){
            //filling the Output model
            var statesOM = mutableListOf<StateOM>()
            states.forEach{
                statesOM.add(StateOM(it.id,it.name, it.project_id ))
            }
            return ReturningData<Collection<StateOM>>(MessageCode.Ok, statesOM)
        }
        return ReturningData<Collection<StateOM>>(MessageCode.GenericError, null )
    }

    override fun deleteProjectStates(project_id: Int) : ReturningData<StateOM>{
        var deleted = stateRepository!!.deleteProjectStates(project_id)
        if(deleted > 0){
            return ReturningData<StateOM>(MessageCode.Ok, null )
        }
        return ReturningData<StateOM>(MessageCode.GenericError, null)
    }
}