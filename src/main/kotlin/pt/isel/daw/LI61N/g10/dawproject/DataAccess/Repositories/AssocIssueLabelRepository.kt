package pt.isel.daw.LI61N.g10.dawproject.DataAccess.Repositories

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Contracts.IAssocIssueLabelDataAccess
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Models.AssocIssueLabel
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.RowMappers.AssocIssueLabelRM

@Repository
class AssocIssueLabelRepository: IAssocIssueLabelDataAccess {
    private val SQL_FIND_BY_ISSUE_NUMBER = "SELECT * FROM [dbo].[Assoc_Issue_Label] WHERE [issue_number] = :issue_number"
    private val SQL_INSERT = "INSERT INTO [dbo].[Assoc_Issue_Label] ([label_id], [issue_number]) values(:label_id, :issue_number)" +
    "select * from [dbo].[Assoc_Issue_Label] where [label_id] = :label_id AND [issue_number] = :issue_number"
    private val SQL_DELETE_BY_ID = "DELETE FROM [dbo].[Assoc_Issue_Label] WHERE [label_id] = :label_id AND [issue_number] = :issue_number"

    private val ROW_MAPPER = AssocIssueLabelRM()

    @Autowired
    var jdbcTemplate: NamedParameterJdbcTemplate? = null

    override fun createAssocIssueLabel(assocIssueLabel: AssocIssueLabel): AssocIssueLabel? {
        val paramSource = MapSqlParameterSource()
                .addValue("label_id", assocIssueLabel.label_id)
                .addValue("issue_number", assocIssueLabel.issue_number)

        return jdbcTemplate!!.queryForObject(SQL_INSERT, paramSource, ROW_MAPPER)
    }

    override fun getAllAssocIssueLabelByIssueID(issue_number: Int): Collection<AssocIssueLabel>? {
        try {
            val paramSource = MapSqlParameterSource("issue_number", issue_number)
            return jdbcTemplate!!.query(SQL_FIND_BY_ISSUE_NUMBER, paramSource, ROW_MAPPER)
        } catch (ex: EmptyResultDataAccessException) {
            return null
        }
    }

    override fun deleteAssocIssueLabel(label_id: Int, issue_number: Int): Int {
        val paramSource = MapSqlParameterSource()
                .addValue("label_id", label_id)
                .addValue("issue_number", issue_number)

        return jdbcTemplate!!.update(SQL_DELETE_BY_ID, paramSource)
    }
}