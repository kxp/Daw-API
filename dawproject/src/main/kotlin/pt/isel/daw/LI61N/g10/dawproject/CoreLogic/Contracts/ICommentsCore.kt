package pt.isel.daw.LI61N.g10.dawproject.CoreLogic.Contracts

import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.AuthIM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.CommentsIM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.CommentsOM
import pt.isel.daw.LI61N.g10.dawproject.Helpers.ReturningData

interface ICommentsCore {
    fun CreateComment(proj :CommentsIM) : ReturningData<CommentsOM>

    fun ChangeComment(proj: CommentsIM) :ReturningData<CommentsOM>

    fun DeleteComment(projectID : Int, issueID: Int, id: Int):ReturningData<CommentsOM>

    fun GetComments(id :Int): ReturningData<Collection<CommentsOM>>
}