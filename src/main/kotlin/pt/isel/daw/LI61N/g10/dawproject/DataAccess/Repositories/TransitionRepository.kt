package pt.isel.daw.LI61N.g10.dawproject.DataAccess.Repositories

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Contracts.ITransitionDataAccess
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Models.Transition
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.RowMappers.TransitionRM

@Repository
class TransitionRepository: ITransitionDataAccess {

    private val SQL_FIND_BY_PROJECT_ID = "SELECT * FROM [dbo].[Transitions] WHERE project_id = :project_id"
    private val SQL_INSERT = "INSERT INTO [dbo].[Transitions] ([project_id], [initial_state_id], [target_state_id]) values(:project_id, :initial_state_id, :target_state_id)"
    private val SQL_DELETE_BY_ID = "DELETE FROM [dbo].[Transitions] WHERE [project_id] = :project_id AND [initial_state_id] = :initial_state_id AND [target_state_id] = :target_state_id"

    private val ROW_MAPPER = TransitionRM()

    @Autowired
    var jdbcTemplate: NamedParameterJdbcTemplate? = null

    override fun createTransition(transition: Transition): Int {
        val paramSource = MapSqlParameterSource()
                .addValue("number", transition.project_id)
                .addValue("name", transition.initial_state_id)
                .addValue("short_desc", transition.target_state_id)

        return jdbcTemplate!!.update(SQL_INSERT, paramSource)
    }

    override fun getProjectStateTransitions(project_id: Int?): Collection<Transition>? {
        try {
            val paramSource = MapSqlParameterSource("project_id", project_id)
            return jdbcTemplate!!.query(SQL_FIND_BY_PROJECT_ID, paramSource, ROW_MAPPER)
        } catch (ex: EmptyResultDataAccessException) {
            return null
        }
    }

    override fun deleteTransition(transition: Transition) : Int {
        val paramSource = MapSqlParameterSource()
                .addValue("number", transition.project_id)
                .addValue("name", transition.initial_state_id)
                .addValue("name", transition.target_state_id)

        return jdbcTemplate!!.update(SQL_DELETE_BY_ID, paramSource)
    }
}