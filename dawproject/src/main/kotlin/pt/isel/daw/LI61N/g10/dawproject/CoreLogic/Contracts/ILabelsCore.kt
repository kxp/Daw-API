package pt.isel.daw.LI61N.g10.dawproject.CoreLogic.Contracts

import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.AuthIM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.LabelsIM

interface ILabelsCore {
    fun ChangeLabels(authIM : AuthIM, projectID :Int, labelsIM :LabelsIM)

    fun GetLabels(authIM : AuthIM, projectID :Int): Iterable<LabelsIM>
}