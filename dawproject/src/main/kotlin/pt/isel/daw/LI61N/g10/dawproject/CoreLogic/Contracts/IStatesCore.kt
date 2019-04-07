package pt.isel.daw.LI61N.g10.dawproject.CoreLogic.Contracts

import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.AuthIM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.StatesIM

interface IStatesCore {
    fun ChangeStates(authIM : AuthIM, projectID :Int, labels :StatesIM)

    fun GetStates(authIM : AuthIM, projectID :Int): List<StatesIM>
}