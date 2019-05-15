package pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels

import java.util.*


data class CommentOM (val id : Int,
                       var text :String,
                       var issueID: Int,
                       var creationDate: Date)