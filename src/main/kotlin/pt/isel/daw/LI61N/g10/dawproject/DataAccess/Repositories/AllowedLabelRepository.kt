package pt.isel.daw.LI61N.g10.dawproject.DataAccess.Repositories

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Contracts.IAllowedLabelDataAccess
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Models.AllowedLabel
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Models.AssocIssueLabel
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.RowMappers.AllowedLabelRM

@Repository
class AllowedLabelRepository: IAllowedLabelDataAccess {

    private val SQL_FIND_BY_ISSUE_NUMBER = "SELECT * FROM [dbo].[AllowedLabels] WHERE project_id = :project_id"
    private val SQL_INSERT = "INSERT INTO [dbo].[AllowedLabels] ([project_id], [label_id]) values(:project_id, :label_id)"
    private val SQL_DELETE_BY_ID = "DELETE FROM [dbo].[AllowedLabels] WHERE [project_id] = :project_id AND [label_id] = :label_id"

    private val ROW_MAPPER = AllowedLabelRM()

    @Autowired
    var jdbcTemplate: NamedParameterJdbcTemplate? = null

    override fun AddAllowedLabelToProject(allowedLabel: AllowedLabel): Int {
        val paramSource = MapSqlParameterSource()
                .addValue("project_id", allowedLabel.project_id)
                .addValue("label_id", allowedLabel.label_id)

        return jdbcTemplate!!.update(SQL_INSERT, paramSource)
    }

    override fun getProjectAllowedLabels(project_id: Int?): Collection<AllowedLabel>? {
        try {
            val paramSource = MapSqlParameterSource("project_id", project_id)
            return jdbcTemplate!!.query(SQL_FIND_BY_ISSUE_NUMBER, paramSource, ROW_MAPPER)
        } catch (ex: EmptyResultDataAccessException) {
            return null
        }
    }

    override fun deleteProjectAllowedLabel(allowedLabel: AllowedLabel) : Int {
        val paramSource = MapSqlParameterSource()
                .addValue("project_id", allowedLabel.project_id)
                .addValue("label_id", allowedLabel.label_id)

        return jdbcTemplate!!.update(SQL_DELETE_BY_ID, paramSource)
    }

}