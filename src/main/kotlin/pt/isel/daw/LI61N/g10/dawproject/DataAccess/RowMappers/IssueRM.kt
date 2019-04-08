package pt.isel.daw.LI61N.g10.dawproject.DataAccess.RowMappers

import org.springframework.jdbc.core.RowMapper
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Models.Issue
import java.sql.ResultSet
import java.sql.SQLException
import java.util.*

class IssueRM: RowMapper<Issue> {

    @Throws(SQLException::class)
    override fun mapRow(rs: ResultSet, rowNum: Int): Issue {
        val issue = Issue(
                rs.getInt("number"),
                rs.getString("name"),
                rs.getString("short_desc"),
                rs.getDate("creation_date"),
                rs.getDate("close_date"),
                rs.getInt("state_id"),
                rs.getInt("project_id")
        )
        return issue
    }
}