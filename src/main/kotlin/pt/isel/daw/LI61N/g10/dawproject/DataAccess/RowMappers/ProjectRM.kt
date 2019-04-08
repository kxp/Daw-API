package pt.isel.daw.LI61N.g10.dawproject.DataAccess.RowMappers

import org.springframework.jdbc.core.RowMapper
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Models.Project
import java.sql.SQLException
import java.sql.ResultSet

class ProjectRM: RowMapper<Project>{

    @Throws(SQLException::class)
    override fun mapRow(rs: ResultSet, rowNum: Int): Project {
        val project = Project(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("short_desc"),
                rs.getInt("user_id"))
        return project
    }
}