package pt.isel.daw.LI61N.g10.dawproject.CoreLogic.Contracts

import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.AuthIM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.StatesIM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.StatesOM
import pt.isel.daw.LI61N.g10.dawproject.Helpers.ReturningData

interface IStatesCore {
    fun ChangeStates(authIM : AuthIM, projectID :Int, labels :StatesIM) : ReturningData<Collection<StatesOM>>

    fun GetStates(authIM : AuthIM, projectID :Int): ReturningData<Collection<StatesOM>>
}