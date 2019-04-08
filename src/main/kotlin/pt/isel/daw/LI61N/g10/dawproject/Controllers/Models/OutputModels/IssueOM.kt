package pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels

import java.util.*


data class IssueOM (val id : Int,
                    var name :String,
                    var short_desc : String,
                    var creationDate: Date,
                    var closeDate :Date,
                    var stateID :Int,
                    var projectID: Int)
