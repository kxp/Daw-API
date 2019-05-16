package pt.isel.daw.LI61N.g10.dawproject.CoreLogic

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.TransitionIM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.TransitionOM
import pt.isel.daw.LI61N.g10.dawproject.CoreLogic.Contracts.ITransitionsCore
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Contracts.IAssocIssueLabelDataAccess
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Contracts.ITransitionDataAccess
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Models.Transition
import pt.isel.daw.LI61N.g10.dawproject.Helpers.MessageCode
import pt.isel.daw.LI61N.g10.dawproject.Helpers.ReturningData

@Service
class TransitionCore : ITransitionsCore {

    @Autowired
    private val transitionRepository: ITransitionDataAccess? = null

    override fun changeTransitions(project_id: Int, transitions: Collection<TransitionIM>): ReturningData<Collection<TransitionOM>> {
        var transitionsToRet = transitionRepository!!.createProjectTransitions(project_id, transitions.map {transition-> Transition(transition.projectID, transition.initialStateID, transition.targetStateID)})

        if(transitionsToRet != null){
            return ReturningData<Collection<TransitionOM>>(MessageCode.Ok, transitionsToRet.map { transition -> convertFromTransitionToTransitionOM(transition) })
        }
        return ReturningData<Collection<TransitionOM>>(MessageCode.GenericError, null)
    }

    override fun deleteTransitions(project_id: Int): ReturningData<TransitionOM> {
        var deleted = transitionRepository!!.deleteProjectTransitions(project_id)
        if(deleted > 0){
            return ReturningData<TransitionOM>(MessageCode.Ok, null )
        }
        return ReturningData<TransitionOM>(MessageCode.GenericError, null)
    }

    override fun getTransitions(project_id: Int): ReturningData<Collection<TransitionOM>> {
        var transitions = transitionRepository!!.getProjectTransitions(project_id)

        if(transitions != null){
            //filling the Output model
            var statesOM = mutableListOf<TransitionOM>()
            transitions.forEach{
                statesOM.add(convertFromTransitionToTransitionOM(it))
            }
            return ReturningData<Collection<TransitionOM>>(MessageCode.Ok, statesOM)
        }
        return ReturningData<Collection<TransitionOM>>(MessageCode.GenericError, null )
    }

    private fun convertFromTransitionToTransitionOM(transition : Transition) : TransitionOM {
        return TransitionOM(transition.project_id, transition.initial_state_id, transition.target_state_id)
    }
}