package pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels


data class IssueIM (val id : Int,
                    var name :String,
                    var short_desc : String,
                    var creationDate: Int,
                    var closeDate :Int,
                    var stateID :Int ,
                    var projectID: Int)
