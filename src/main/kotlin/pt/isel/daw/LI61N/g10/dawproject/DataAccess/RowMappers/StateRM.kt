package pt.isel.daw.LI61N.g10.dawproject.DataAccess.RowMappers

import org.springframework.jdbc.core.RowMapper
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Models.State
import java.sql.ResultSet
import java.sql.SQLException

class StateRM: RowMapper<State> {

    @Throws(SQLException::class)
    override fun mapRow(rs: ResultSet, rowNum: Int): State {
        val state = State(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getInt("project_id"))
        return state
    }
}