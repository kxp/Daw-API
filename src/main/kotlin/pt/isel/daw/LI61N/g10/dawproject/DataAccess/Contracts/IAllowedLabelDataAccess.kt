package pt.isel.daw.LI61N.g10.dawproject.DataAccess.Contracts

import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Models.AllowedLabel

interface IAllowedLabelDataAccess {

    fun AddAllowedLabelToProject(allowedLabel: AllowedLabel): Int

    fun getProjectAllowedLabels(project_id: Int?): Collection<AllowedLabel>?

    fun deleteProjectAllowedLabel(allowedLabel: AllowedLabel): Int
}