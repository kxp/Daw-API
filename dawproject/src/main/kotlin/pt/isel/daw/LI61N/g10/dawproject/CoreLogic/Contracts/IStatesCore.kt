package pt.isel.daw.LI61N.g10.dawproject.CoreLogic.Contracts

import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.Auth
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.States

interface IStatesCore {
    fun ChangeStates(auth : Auth, projectID :Int, labels :States)

    fun GetStates(auth : Auth, projectID :Int): List<States>
}