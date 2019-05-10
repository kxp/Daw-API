package pt.isel.daw.LI61N.g10.dawproject.DataAccess.Models

import java.util.*

data class Issue (
        val number : Int,
        var name :String,
        var short_desc : String,
        var creation_date : Date,
        var close_date : Date?,
        val state_id : Int,
        val project_id: Int)