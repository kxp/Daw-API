package pt.isel.daw.LI61N.g10.dawproject.DataAccess.Repositories

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Contracts.ICommentDataAccess
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Models.Comment
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.RowMappers.CommentRM

@Repository
class CommentRepository: ICommentDataAccess {

    private val SQL_UPDATE = "UPDATE * FROM [dbo].[Comments] SET [short_text] = :short_text WHERE [id] = :id"
    private val SQL_FIND_BY_ISSUE_ID = "SELECT * FROM [dbo].[Comments] WHERE [issue_id] = :issue_id"
    private val SQL_INSERT = "INSERT INTO [dbo].[Comments] ([short_text], [issue_id], [creation_date]) values( :short_text, :issue_id, :creation_date)" +
    "select * from [dbo].[Comments] where [id] = (SELECT SCOPE_IDENTITY())"
    private val SQL_DELETE_BY_ID = "DELETE FROM [dbo].[Comments] WHERE [id] = :id"

    private val ROW_MAPPER = CommentRM()

    @Autowired
    var jdbcTemplate: NamedParameterJdbcTemplate? = null

    override fun updateComment(comment: Comment): Int {
        val paramSource = MapSqlParameterSource()
                .addValue("short_text", comment.short_text)
                .addValue("issue_id", comment.issue_id)
                .addValue("creation_date", comment.creationDate)

        return jdbcTemplate!!.update(SQL_UPDATE, paramSource)
    }

    override fun createComment(comment: Comment): Comment? {
        val paramSource = MapSqlParameterSource()
                .addValue("short_text", comment.short_text)
                .addValue("issue_id", comment.issue_id)
                .addValue("creation_date", comment.creationDate)

        //return jdbcTemplate!!.update(SQL_INSERT, paramSource)
        return jdbcTemplate!!.queryForObject(SQL_INSERT, paramSource, ROW_MAPPER)
    }

    override fun getCommentsByIssueID(issueID: Int): Collection<Comment> {
        val paramSource = MapSqlParameterSource("issue_id", issueID)
        return jdbcTemplate!!.query(SQL_FIND_BY_ISSUE_ID, paramSource, ROW_MAPPER)
    }

    override fun deleteComment(id: Int?) : Int {
        val paramSource = MapSqlParameterSource("id", id)
        return jdbcTemplate!!.update(SQL_DELETE_BY_ID, paramSource)
    }
}