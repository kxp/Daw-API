package pt.isel.daw.LI61N.g10.dawproject.CoreLogic.Contracts

import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.AuthIM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.LabelsIM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.LabelsOM

interface ILabelsCore {
    fun ChangeLabels(authIM : AuthIM, projectID :Int, labelsIM :LabelsIM) : Iterable<LabelsOM>

    fun GetLabels(authIM : AuthIM, projectID :Int): Iterable<LabelsOM>
}