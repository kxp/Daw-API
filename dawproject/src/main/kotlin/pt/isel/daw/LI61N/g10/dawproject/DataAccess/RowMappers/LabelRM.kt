package pt.isel.daw.LI61N.g10.dawproject.DataAccess.RowMappers

import org.springframework.jdbc.core.RowMapper
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Models.Label
import java.sql.ResultSet
import java.sql.SQLException

class LabelRM: RowMapper<Label> {

    @Throws(SQLException::class)
    override fun mapRow(rs: ResultSet, rowNum: Int): Label {
        val label = Label(
                rs.getInt("id"),
                rs.getString("name")
        )
        return label
    }
}