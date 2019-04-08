package pt.isel.daw.LI61N.g10.dawproject.DataAccess.Repositories

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Contracts.IUserDataAccess
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Models.User
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.RowMappers.UserRM

@Repository
class UserRepository: IUserDataAccess {

    private val SQL_FIND_BY_USERNAME = "SELECT * FROM [dbo].[Users] WHERE USERNAME = :username"
    private val SQL_FIND_BY_ID = "SELECT * FROM [dbo].[Users] WHERE ID = :id"
    private val SQL_INSERT = "INSERT INTO [dbo].[Users] ([id], [username], [password]) values(:id, :username, :password)"
    private val SQL_DELETE_BY_ID = "DELETE FROM [dbo].[Users] WHERE [id] = :id"

    private val ROW_MAPPER = UserRM()

    @Autowired
    var jdbcTemplate: NamedParameterJdbcTemplate? = null

    override fun getUser(user_id: Int?): User? {
        try {
            val paramSource = MapSqlParameterSource("id", user_id)
            return jdbcTemplate!!.queryForObject(SQL_FIND_BY_ID, paramSource, ROW_MAPPER)
        } catch (ex: EmptyResultDataAccessException) {
            return null
        }
    }

    override fun createUser(user: User): Int {
        val paramSource = MapSqlParameterSource()
                .addValue("id", user.id)
                .addValue("username", user.username)
                .addValue("password", user.password)

        return jdbcTemplate!!.update(SQL_INSERT, paramSource)
    }

    override fun deleteUser(id: Int?) {
        val paramSource = MapSqlParameterSource("id", id)
        jdbcTemplate!!.update(SQL_DELETE_BY_ID, paramSource)
    }

    override fun getUser(username: String): User? {
        try {
            val paramSource = MapSqlParameterSource("username", username)
            return jdbcTemplate!!.queryForObject(SQL_FIND_BY_USERNAME, paramSource, ROW_MAPPER)
        } catch (ex: EmptyResultDataAccessException) {
            return null
        }
    }
}