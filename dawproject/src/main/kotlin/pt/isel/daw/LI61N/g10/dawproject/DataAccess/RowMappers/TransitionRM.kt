package pt.isel.daw.LI61N.g10.dawproject.DataAccess.RowMappers

import org.springframework.jdbc.core.RowMapper
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Models.Transition
import java.sql.ResultSet
import java.sql.SQLException

class TransitionRM: RowMapper<Transition> {

    @Throws(SQLException::class)
    override fun mapRow(rs: ResultSet, rowNum: Int): Transition {
        val state = Transition(
                rs.getInt("project_id"),
                rs.getInt("initial_state_id"),
                rs.getInt("target_state_id"))
        return state
    }
}