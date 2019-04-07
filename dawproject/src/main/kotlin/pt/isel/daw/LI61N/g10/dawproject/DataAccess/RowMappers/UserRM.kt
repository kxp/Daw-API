package pt.isel.daw.LI61N.g10.dawproject.DataAccess.RowMappers

import org.springframework.jdbc.core.RowMapper
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Models.State
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Models.User
import java.sql.ResultSet
import java.sql.SQLException

class UserRM: RowMapper<User> {

    @Throws(SQLException::class)
    override fun mapRow(rs: ResultSet, rowNum: Int): User {
        val user = User(
                rs.getInt("id"),
                rs.getString("username"),
                rs.getString("password"))
        return user
    }
}