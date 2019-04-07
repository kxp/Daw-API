package pt.isel.daw.LI61N.g10.dawproject.CoreLogic

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.*
import pt.isel.daw.LI61N.g10.dawproject.CoreLogic.Contracts.*
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Contracts.IProjectDataAccess

@Service
class CoreImplementation : ICommentsCore, IIssuesCore, ILabelsCore, IStatesCore, ITransitionsCore, IProjectCore {


    @Autowired
    private val projectRepository: IProjectDataAccess? = null

    /* Labels part*/

    override fun GetLabels(authIM: AuthIM, projectID: Int): List<LabelsIM> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun ChangeLabels(authIM: AuthIM, projectID: Int, labelsIM: LabelsIM) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /* State part */

    override fun ChangeStates(authIM: AuthIM, projectID: Int, labels: StatesIM) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun GetStates(authIM: AuthIM, projectID: Int): List<StatesIM> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /* Transitions part */

    override fun CreateTransition(authIM: AuthIM, proj: TransitionsIM) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun ChangeTransition(authIM: AuthIM, proj: TransitionsIM) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun DeleteTransition(authIM: AuthIM, id: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun Getransitions(authIM: AuthIM): List<TransitionsIM> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    /* Project part*/

    override fun DeleteProject(authIM: AuthIM, id: Int) {


        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun GetProjects(authIM: AuthIM): List<ProjectIM> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun CreateProject(authIM: AuthIM, proj: ProjectIM) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun ChangeProject(authIM: AuthIM, id: Int, proj: ProjectIM) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /* Issues part */

    override fun CreateIssue(authIM: AuthIM, projectID: Int, issue: IssueIM) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun ChangeIssue(authIM: AuthIM, projectID: Int, issue: IssueIM) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun DeleteIssue(authIM: AuthIM, projectID: Int, id: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun GetIssues(authIM: AuthIM, projectID: Int): List<IssueIM> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /* Comments part*/

    override fun ChangeComment(authIM: AuthIM, proj: CommentsIM) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun DeleteComment(authIM: AuthIM, id: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun GetComments(authIM: AuthIM): List<CommentsIM> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun CreateComment(authIM: AuthIM, proj: CommentsIM) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}