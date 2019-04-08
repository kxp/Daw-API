package pt.isel.daw.LI61N.g10.dawproject.CoreLogic

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.AuthIM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.IssueOM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.TransitionsIM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.TransitionsOM
import pt.isel.daw.LI61N.g10.dawproject.CoreLogic.Contracts.ITransitionsCore
import pt.isel.daw.LI61N.g10.dawproject.CoreLogic.UserValidation.Companion.Validate
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Contracts.IAssocIssueLabelDataAccess
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Contracts.ITransitionDataAccess
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Models.Transition
import pt.isel.daw.LI61N.g10.dawproject.Helpers.MessageCode
import pt.isel.daw.LI61N.g10.dawproject.Helpers.ReturningData

@Service
class TransitionCore : ITransitionsCore {


    @Autowired
    private val transitionRepository: ITransitionDataAccess? = null

    @Autowired
    private val assocIssueTransRepository: IAssocIssueLabelDataAccess? = null


    override fun CreateTransition(auth: AuthIM, proj: TransitionsIM): ReturningData<TransitionsOM> {


        if (Validate(auth) == false){

            var returnResult = ReturningData<TransitionsOM>(MessageCode.InvalidCredentials, null )
            return returnResult
        }

        //Validate the ids

        var transition = Transition(proj.projectID, proj.initialStateID, proj.targetStateID)
        var cenas  = transitionRepository!!.createTransition(transition)


        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun ChangeTransition(auth: AuthIM, proj: TransitionsIM): ReturningData<TransitionsOM> {

        if (Validate(auth) == false){

            var returnResult = ReturningData<TransitionsOM>(MessageCode.InvalidCredentials, null )
            return returnResult
        }



        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun DeleteTransition(auth: AuthIM, id: Int) : ReturningData<TransitionsOM> {


        if (Validate(auth) == false){

            var returnResult = ReturningData<TransitionsOM>(MessageCode.InvalidCredentials, null )
            return returnResult
        }

        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        //transitionRepository!!.deleteTransition()
        return ReturningData<TransitionsOM>(MessageCode.Ok, null)
    }

    override fun Getransitions(auth: AuthIM, id: Int): ReturningData<Collection<TransitionsOM>> {

        if (Validate(auth) == false){

            var returnResult = ReturningData<Collection<TransitionsOM>>(MessageCode.InvalidCredentials, null )
            return returnResult
        }

        var transitions = transitionRepository!!.getProjectStateTransitions(id)

        if (transitions == null  || transitions.isEmpty()== true)
        {
            var returnResult = ReturningData<Collection<TransitionsOM>>(MessageCode.GenericError, null )
            return returnResult
        }

        //filling the Output model
        var transitionsList = mutableListOf<TransitionsOM>()
        transitions.forEach{
            transitionsList.add(TransitionsOM(it.project_id , it.initial_state_id,it.target_state_id))
        }

        var returnResult = ReturningData<Collection<TransitionsOM>>(MessageCode.Ok, transitionsList)
        return returnResult
    }

}