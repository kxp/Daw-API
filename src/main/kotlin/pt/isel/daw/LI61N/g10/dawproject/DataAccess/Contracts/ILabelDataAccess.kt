package pt.isel.daw.LI61N.g10.dawproject.DataAccess.Contracts

import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Models.Label

public interface ILabelDataAccess {

    fun getLabels(): Collection<Label>?

    fun deleteLabel(id: Int?)

    fun createLabel(label: Label?): Int
}