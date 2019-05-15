package pt.isel.daw.LI61N.g10.dawproject.DataAccess.Contracts

import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Models.Label

public interface ILabelDataAccess {

    fun getLabelsByProjectID(): Collection<Label>?

    fun getLabelsByProjectID(projectID: Int): Collection<Label>?

    fun deleteLabel(id: Int?): Int

    fun createLabel(label: Label?): Label?
}