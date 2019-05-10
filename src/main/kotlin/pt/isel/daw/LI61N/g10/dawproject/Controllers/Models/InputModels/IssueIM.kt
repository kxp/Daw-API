package pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels

import java.util.*


data class IssueIM (val number : Int,
                    var name :String,
                    var short_desc : String,
                    var stateID :Int ,
                    var projectID: Int)
