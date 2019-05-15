package pt.isel.daw.LI61N.g10.dawproject.CoreLogic.Contracts

import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.LabelIM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.LabelOM
import pt.isel.daw.LI61N.g10.dawproject.Helpers.ReturningData

interface ILabelsCore {
    fun getLabels(projectID :Int): ReturningData<Collection<LabelOM>>

    fun createLabel(proj :LabelIM) : ReturningData<LabelOM>

    fun deleteLabel(label_id: Int) : ReturningData<LabelOM>
}