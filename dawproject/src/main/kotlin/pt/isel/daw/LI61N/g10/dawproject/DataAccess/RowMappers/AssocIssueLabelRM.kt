package pt.isel.daw.LI61N.g10.dawproject.DataAccess.RowMappers

import org.springframework.jdbc.core.RowMapper
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Models.AssocIssueLabel
import java.sql.ResultSet
import java.sql.SQLException

class AssocIssueLabelRM: RowMapper<AssocIssueLabel> {

    @Throws(SQLException::class)
    override fun mapRow(rs: ResultSet, rowNum: Int): AssocIssueLabel {
        val assocIssueLabel = AssocIssueLabel(
                rs.getInt("label_id"),
                rs.getInt("issue_number")
        )
        return assocIssueLabel
    }
}