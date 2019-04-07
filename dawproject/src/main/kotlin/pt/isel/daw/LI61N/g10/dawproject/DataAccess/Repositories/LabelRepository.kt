package pt.isel.daw.LI61N.g10.dawproject.DataAccess.Repositories

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Contracts.ILabelDataAccess
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Models.Label
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.RowMappers.LabelRM

@Repository
class LabelRepository: ILabelDataAccess {

    private val SQL_FIND_ALL = "SELECT * FROM [dbo].[Labels]"
    private val SQL_INSERT = "INSERT INTO [dbo].[Labels] ([name]) values(:name)"
    private val SQL_DELETE_BY_ID = "DELETE FROM [dbo].[Labels] WHERE [id] = :id"

    private val ROW_MAPPER = LabelRM()

    @Autowired
    var jdbcTemplate: NamedParameterJdbcTemplate? = null

    override fun getLabels(): Collection<Label>? {
        try {
            return jdbcTemplate!!.query(SQL_FIND_ALL, ROW_MAPPER)
        } catch (ex: EmptyResultDataAccessException) {
            return null
        }
    }

    override fun deleteLabel(id: Int?) {
        val paramSource = MapSqlParameterSource("id", id)
        jdbcTemplate!!.update(SQL_DELETE_BY_ID, paramSource)
    }

    override fun createLabel(label: Label?): Int {
        val paramSource = MapSqlParameterSource()
                .addValue("name", label!!.name)

        return jdbcTemplate!!.update(SQL_INSERT, paramSource)
    }
}