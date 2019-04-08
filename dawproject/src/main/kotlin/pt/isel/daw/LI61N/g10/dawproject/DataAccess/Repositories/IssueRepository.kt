package pt.isel.daw.LI61N.g10.dawproject.DataAccess.Repositories

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Contracts.IIssueDataAccess
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Models.Issue
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.RowMappers.IssueRM

@Repository
class IssueRepository: IIssueDataAccess {

    private val SQL_FIND_BY_PROJECT_ID = "SELECT * FROM [dbo].[Issues] WHERE project_id = :project_id"
    private val SQL_FIND_BY_ID = "SELECT * FROM [dbo].[Issues] WHERE number = :number"
    private val SQL_INSERT = "INSERT INTO [dbo].[Issues] ([name], [short_desc], [creation_date], [close_date], [state_id], [project_id]) values(:name, :short_desc, :creation_date, :close_date, :state_id, :project_id)"
    private val SQL_DELETE_BY_ID = "DELETE FROM [dbo].[Issues] WHERE [number] = :number"

    private val ROW_MAPPER = IssueRM()

    @Autowired
    var jdbcTemplate: NamedParameterJdbcTemplate? = null

    override fun getProjectIssue(issue_number: Int?): Issue? {
        try {
            val paramSource = MapSqlParameterSource("number", issue_number)
            return jdbcTemplate!!.queryForObject(SQL_FIND_BY_ID, paramSource, ROW_MAPPER)
        } catch (ex: EmptyResultDataAccessException) {
            return null
        }
    }

    override fun createProjectIssue(issue: Issue): Int {
        val paramSource = MapSqlParameterSource()
                .addValue("number", issue.number)
                .addValue("name", issue.name)
                .addValue("short_desc", issue.short_desc)
                .addValue("creation_date", issue.creation_date)
                .addValue("close_date", issue.close_date)
                .addValue("state_id", issue.state_id)
                .addValue("project_id", issue.project_id)

        return jdbcTemplate!!.update(SQL_INSERT, paramSource)
    }

    override fun getProjectIssues(project_id: Int?): Collection<Issue>? {
        try {
            val paramSource = MapSqlParameterSource("project_id", project_id)
            return jdbcTemplate!!.query(SQL_FIND_BY_PROJECT_ID, paramSource, ROW_MAPPER)
        } catch (ex: EmptyResultDataAccessException) {
            return null
        }
    }

    override fun deleteIssue(number: Int?) {
        val paramSource = MapSqlParameterSource("number", number)
        jdbcTemplate!!.update(SQL_DELETE_BY_ID, paramSource)
    }
}