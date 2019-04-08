package pt.isel.daw.LI61N.g10.dawproject.CoreLogic.Contracts

import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.AuthIM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.LabelsIM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.LabelsOM
import pt.isel.daw.LI61N.g10.dawproject.Helpers.ReturningData

interface ILabelsCore {
    fun ChangeLabels(projectID :Int, labelsIM :LabelsIM) : ReturningData<Collection<LabelsOM>>

    fun GetLabels(projectID :Int): ReturningData<Collection<LabelsOM>>
}