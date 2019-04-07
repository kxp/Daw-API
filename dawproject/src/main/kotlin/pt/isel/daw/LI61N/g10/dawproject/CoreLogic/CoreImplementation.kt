package pt.isel.daw.LI61N.g10.dawproject.CoreLogic

import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.*
import pt.isel.daw.LI61N.g10.dawproject.CoreLogic.Contracts.*

class CoreImplementation : ICommentsCore, IIssuesCore, ILabelsCore, IStatesCore, ITransitionsCore, IProjectCore {
    override fun GetLabels(auth: Auth, projectID: Int): List<Labels> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun ChangeStates(auth: Auth, projectID: Int, labels: States) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun GetStates(auth: Auth, projectID: Int): List<States> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun ChangeLabels(auth: Auth, projectID: Int, labels: Labels) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun CreateTransition(auth: Auth, proj: Transitions) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun ChangeTransition(auth: Auth, proj: Transitions) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun DeleteTransition(auth: Auth, id: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun Getransitions(auth: Auth): List<Transitions> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun DeleteProject(auth: Auth, id: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun GetProjects(auth: Auth): List<Project> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun ChangeComment(auth: Auth, proj: Comments) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun DeleteComment(auth: Auth, id: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun GetComments(auth: Auth): List<Comments> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun CreateIssue(auth: Auth, projectID: Int, issue: Issue) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun ChangeIssue(auth: Auth, projectID: Int, issue: Issue) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun DeleteIssue(auth: Auth, projectID: Int, id: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun GetIssues(auth: Auth, projectID: Int): List<Issue> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun CreateProject(auth: Auth, proj: Project) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun ChangeProject(auth: Auth, id: Int, proj: Project) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun CreateComment(auth: Auth, proj: Comments) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}