package pt.isel.daw.LI61N.g10.dawproject.DataAccess.RowMappers

import org.springframework.jdbc.core.RowMapper
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Models.AllowedLabel
import java.sql.ResultSet
import java.sql.SQLException

class AllowedLabelRM: RowMapper<AllowedLabel> {

    @Throws(SQLException::class)
    override fun mapRow(rs: ResultSet, rowNum: Int): AllowedLabel {
        val allowedLabel = AllowedLabel(
                rs.getInt("project_id"),
                rs.getInt("label_id")
        )
        return allowedLabel
    }
}