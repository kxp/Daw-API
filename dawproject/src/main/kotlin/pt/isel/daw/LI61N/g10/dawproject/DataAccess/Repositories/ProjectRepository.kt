package pt.isel.daw.LI61N.g10.dawproject.DataAccess.Repositories

import org.springframework.stereotype.Repository
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.beans.factory.annotation.Autowired
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Contracts.IProjectDataAccess
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Models.Project
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.RowMappers.ProjectRM


@Repository
class ProjectRepository: IProjectDataAccess {

    private val SQL_FIND_BY_ID = "SELECT * FROM [dbo].[Projects] WHERE ID = :id"
    private val SQL_FIND_ALL = "SELECT * FROM [dbo].[Projects]"
    private val SQL_INSERT = "INSERT INTO [dbo].[Projects] ([name], [short_desc], [user_id]) values(:name, :short_desc, :user_id)"
    private val SQL_DELETE_BY_ID = "DELETE FROM [dbo].[Projects] WHERE [id] = :id"

    private val ROW_MAPPER = ProjectRM()

    @Autowired
    var jdbcTemplate: NamedParameterJdbcTemplate? = null

    override fun getProject(id: Int?): Project? {
        try {
            val paramSource = MapSqlParameterSource("id", id)
            return jdbcTemplate!!.queryForObject(SQL_FIND_BY_ID, paramSource, ROW_MAPPER)
        } catch (ex: EmptyResultDataAccessException) {
            return null
        }
    }

    override fun createProject(project: Project): Int {
        val paramSource = MapSqlParameterSource()
                .addValue("name", project.name)
                .addValue("short_desc", project.short_desc)
                .addValue("user_id", project.user_id)

        return jdbcTemplate!!.update(SQL_INSERT, paramSource)
    }

    override fun getProjects(): Iterable<Project> {
        return jdbcTemplate!!.query(SQL_FIND_ALL, ROW_MAPPER)
    }

    override fun deleteProject(id: Int?) {
        val paramSource = MapSqlParameterSource("id", id)
        jdbcTemplate!!.update(SQL_DELETE_BY_ID, paramSource)
    }
}