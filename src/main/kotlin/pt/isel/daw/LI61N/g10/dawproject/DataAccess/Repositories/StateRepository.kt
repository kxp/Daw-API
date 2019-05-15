package pt.isel.daw.LI61N.g10.dawproject.DataAccess.Repositories

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Contracts.IProjectStatesDataAccess
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Models.State
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.RowMappers.StateRM
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils


@Repository
class StateRepository: IProjectStatesDataAccess {

    private val SQL_FIND_BY_ID = "SELECT * FROM [dbo].[States] WHERE project_id = :project_id"
    private val SQL_INSERT = "INSERT INTO [dbo].[States] ([name], [project_id]) values(:name, :project_id)"
    private val SQL_DELETE_BY_ID = "DELETE FROM [dbo].[States] WHERE [project_id] = :project_id"

    private val ROW_MAPPER = StateRM()

    @Autowired
    var jdbcTemplate: NamedParameterJdbcTemplate? = null

    override fun getProjectStates(id: Int?): Collection<State>? {
        try {
            val paramSource = MapSqlParameterSource("project_id", id)
            return jdbcTemplate!!.query(SQL_FIND_BY_ID, paramSource, ROW_MAPPER)
        } catch (ex: EmptyResultDataAccessException) {
            return null
        }
    }

    override fun deleteProjectStates(id: Int?) : Int {
        val paramSource = MapSqlParameterSource("project_id", id)
        return jdbcTemplate!!.update(SQL_DELETE_BY_ID, paramSource)
    }

    override fun createProjectStates(project_id :Int, states: Collection<State>) : Collection<State>?{
        if(states != null && states.isNotEmpty())
        {
            var states_list = states.toList();
            val arrayParamSource = Array<MapSqlParameterSource>((states as Collection<MapSqlParameterSource>).size, { position ->
                MapSqlParameterSource()
                        .addValue("name", states_list.elementAt(position).name)
                        .addValue("project_id", states_list.elementAt(position).project_id) })

            jdbcTemplate!!.batchUpdate(SQL_INSERT, arrayParamSource as Array<MapSqlParameterSource>)

            return getProjectStates(project_id)
        }
        else { //if whe receive an empty list
            deleteProjectStates(project_id)
            return listOf<String>() as Collection<State>
        }
        return null
    }
}