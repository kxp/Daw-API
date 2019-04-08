package pt.isel.daw.LI61N.g10.dawproject.DataAccess.RowMappers

import org.springframework.jdbc.core.RowMapper
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Models.Comment
import java.sql.ResultSet
import java.sql.SQLException

class CommentRM: RowMapper<Comment> {

    @Throws(SQLException::class)
    override fun mapRow(rs: ResultSet, rowNum: Int): Comment {
        val comment = Comment(
                rs.getInt("id"),
                rs.getString("short_text"),
                rs.getInt("issue_id")
        )
        return comment
    }
}