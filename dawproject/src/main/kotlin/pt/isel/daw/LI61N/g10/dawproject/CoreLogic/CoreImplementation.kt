package pt.isel.daw.LI61N.g10.dawproject.CoreLogic

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.*
import pt.isel.daw.LI61N.g10.dawproject.CoreLogic.Contracts.*
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Contracts.IProjectDataAccess
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Contracts.IProjectStatesDataAccess
import pt.isel.daw.LI61N.g10.dawproject.Helpers.MessageCode
import pt.isel.daw.LI61N.g10.dawproject.Helpers.ReturningData

@Service
class CoreImplementation : ICommentsCore, IIssuesCore, ILabelsCore, IStatesCore, ITransitionsCore, IProjectCore {


    @Autowired
    private val projectRepository: IProjectDataAccess? = null

    @Autowired
    private val stateRepository: IProjectStatesDataAccess? = null

    /* Labels part*/

    override fun ChangeLabels(auth: AuthIM, projectID: Int, labelsIM: LabelsIM): ReturningData<Collection<LabelsOM>> {

        if (Validate(auth) == false){

            var returnResult = ReturningData<Collection<LabelsOM>>(MessageCode.InvalidCredentials, null )
            return returnResult
        }

        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun GetLabels(auth: AuthIM, projectID: Int): ReturningData<Collection<LabelsOM>> {


        if (Validate(auth) == false){

            var returnResult = ReturningData<Collection<LabelsOM>>(MessageCode.InvalidCredentials, null )
            return returnResult
        }

        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    /* State part */

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

        var returnResult = ReturningData<Collection<StatesOM>>(MessageCode.GenericError, cenas)
        return returnResult

    }

    /* Transitions part */

    override fun CreateTransition(auth: AuthIM, proj: TransitionsIM): ReturningData<TransitionsOM> {


        if (Validate(auth) == false){

            var returnResult = ReturningData<TransitionsOM>(MessageCode.InvalidCredentials, null )
            return returnResult
        }

        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun ChangeTransition(auth: AuthIM, proj: TransitionsIM): ReturningData<TransitionsOM> {

        if (Validate(auth) == false){

            var returnResult = ReturningData<TransitionsOM>(MessageCode.InvalidCredentials, null )
            return returnResult
        }

        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun DeleteTransition(auth: AuthIM, id: Int) :  ReturningData<TransitionsOM> {


        if (Validate(auth) == false){

            var returnResult = ReturningData<TransitionsOM>(MessageCode.InvalidCredentials, null )
            return returnResult
        }
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun Getransitions(auth: AuthIM): ReturningData<Collection<TransitionsOM>> {

        if (Validate(auth) == false){

            var returnResult = ReturningData<Collection<TransitionsOM>>(MessageCode.InvalidCredentials, null )
            return returnResult
        }

        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /* Project part*/

    override fun CreateProject(auth: AuthIM, proj: ProjectIM): ReturningData<ProjectOM> {

        if (Validate(auth) == false){

            var returnResult = ReturningData<ProjectOM>(MessageCode.InvalidCredentials, null )
            return returnResult
        }
        //projectRepository!!.createProject()
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun ChangeProject(auth: AuthIM, id: Int, proj: ProjectIM): ReturningData<ProjectOM> {


        if (Validate(auth) == false){

            var returnResult = ReturningData<ProjectOM>(MessageCode.InvalidCredentials, null )
            return returnResult
        }
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun DeleteProject(auth: AuthIM, id: Int) : ReturningData<ProjectOM> {

        if (Validate(auth) == false){

            var returnResult = ReturningData<ProjectOM>(MessageCode.InvalidCredentials, null )
            return returnResult
        }

        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun GetProjects(auth: AuthIM): ReturningData<Collection<ProjectOM>> {


        if (Validate(auth) == false){

            var returnResult = ReturningData<Collection<ProjectOM>>(MessageCode.InvalidCredentials, null )
            return returnResult
        }

        var result = projectRepository!!.getProjects()


        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /* Issues part */

    override fun CreateIssue(auth: AuthIM, projectID: Int, issue: IssueIM): ReturningData<IssueOM> {


        if (Validate(auth) == false){

            var returnResult = ReturningData<IssueOM>(MessageCode.InvalidCredentials, null )
            return returnResult
        }
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun ChangeIssue(auth: AuthIM, projectID: Int, issue: IssueIM): ReturningData<IssueOM> {

        if (Validate(auth) == false){

            var returnResult = ReturningData<IssueOM>(MessageCode.InvalidCredentials, null )
            return returnResult
        }

        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun DeleteIssue(auth: AuthIM, projectID: Int, id: Int) : ReturningData<IssueOM>{

        if (Validate(auth) == false){

            var returnResult = ReturningData<IssueOM>(MessageCode.InvalidCredentials, null )
            return returnResult
        }

        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun GetIssues(auth: AuthIM, projectID: Int): ReturningData<Collection<IssueOM>> {

        if (Validate(auth) == false){

            var returnResult = ReturningData<Collection<IssueOM>>(MessageCode.InvalidCredentials, null )
            return returnResult
        }

        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    /* Comments part*/

    override fun CreateComment(auth: AuthIM, proj: CommentsIM): ReturningData<CommentsOM> {

        if (Validate(auth) == false){

            var returnResult = ReturningData<CommentsOM>(MessageCode.InvalidCredentials, null )
            return returnResult
        }

        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun ChangeComment(auth: AuthIM, proj: CommentsIM): ReturningData<CommentsOM> {


        if (Validate(auth) == false){

            var returnResult = ReturningData<CommentsOM>(MessageCode.InvalidCredentials, null )
            return returnResult
        }
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun DeleteComment(auth: AuthIM, id: Int): ReturningData<CommentsOM> {

        if (Validate(auth) == false){

            var returnResult = ReturningData<CommentsOM>(MessageCode.InvalidCredentials, null )
            return returnResult
        }
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun GetComments(auth: AuthIM): ReturningData<Collection<CommentsOM>> {

        if (Validate(auth) == false){

            var returnResult = ReturningData<Collection<CommentsOM>>(MessageCode.InvalidCredentials, null )
            return returnResult
        }
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    private fun Validate(auth :AuthIM ) : Boolean{

        //TODO("Go to the DB and Check")
        return true
    }

}