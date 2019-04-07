package pt.isel.daw.LI61N.g10.dawproject.CoreLogic.Contracts

import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.Auth
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.Labels

interface ILabelsCore {
    fun ChangeLabels(auth : Auth, projectID :Int, labels :Labels)

    fun GetLabels(auth : Auth, projectID :Int): List<Labels>
}