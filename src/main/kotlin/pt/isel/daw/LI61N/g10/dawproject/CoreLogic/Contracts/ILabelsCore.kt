package pt.isel.daw.LI61N.g10.dawproject.CoreLogic.Contracts

import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.AuthIM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.LabelsIM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.LabelsOM
import pt.isel.daw.LI61N.g10.dawproject.Helpers.ReturningData

interface ILabelsCore {
    fun changeLabels(projectID :Int, labelsIM :LabelsIM) : ReturningData<Collection<LabelsOM>>

    fun getLabels(projectID :Int): ReturningData<Collection<LabelsOM>>
}