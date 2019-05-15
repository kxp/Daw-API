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
    private val SQL_DELETE_ALL_BY_PROJECT_ID = "DELETE FROM [dbo].[Transitions] WHERE [project_id] = :project_id"

    private val ROW_MAPPER = TransitionRM()

    @Autowired
    var jdbcTemplate: NamedParameterJdbcTemplate? = null

    override fun getProjectTransitions(project_id: Int?): Collection<Transition>? {
        try {
            val paramSource = MapSqlParameterSource("project_id", project_id)
            return jdbcTemplate!!.query(SQL_FIND_BY_PROJECT_ID, paramSource, ROW_MAPPER)
        } catch (ex: EmptyResultDataAccessException) {
            return null
        }
    }

    override fun deleteProjectTransitions(project_id: Int): Int {
        val paramSource = MapSqlParameterSource("project_id", project_id)
        return jdbcTemplate!!.update(SQL_DELETE_ALL_BY_PROJECT_ID, paramSource)
    }

    override fun createProjectTransitions(project_id: Int, transitions: Collection<Transition>): Collection<Transition>? {
        if(transitions != null && transitions.isNotEmpty())
        {
            var states_list = transitions.toList();
            val arrayParamSource = Array<MapSqlParameterSource>((transitions as Collection<MapSqlParameterSource>).size, { position ->
                MapSqlParameterSource()
                        .addValue("project_id", states_list.elementAt(position).project_id)
                        .addValue("initial_state_id", states_list.elementAt(position).initial_state_id)
                        .addValue("target_state_id", states_list.elementAt(position).target_state_id) })

            jdbcTemplate!!.batchUpdate(SQL_INSERT, arrayParamSource as Array<MapSqlParameterSource>)

            return getProjectTransitions(project_id)
        }
        else { //if whe receive an empty list
            deleteProjectTransitions(project_id)
            return listOf<String>() as Collection<Transition>
        }
        return null
    }




    fun createTransition(transition: Transition): Int {
        val paramSource = MapSqlParameterSource()
                .addValue("number", transition.project_id)
                .addValue("name", transition.initial_state_id)
                .addValue("short_desc", transition.target_state_id)

        return jdbcTemplate!!.update(SQL_INSERT, paramSource)
    }


    fun deleteTransition(transition: Transition) : Int {
        val paramSource = MapSqlParameterSource()
                .addValue("number", transition.project_id)
                .addValue("name", transition.initial_state_id)
                .addValue("name", transition.target_state_id)

        return jdbcTemplate!!.update(SQL_DELETE_BY_ID, paramSource)
    }
}