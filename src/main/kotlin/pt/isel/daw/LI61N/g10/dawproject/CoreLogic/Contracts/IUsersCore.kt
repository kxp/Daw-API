package pt.isel.daw.LI61N.g10.dawproject.CoreLogic.Contracts

import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.UserIM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.OutputModels.UserOM
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Models.User
import pt.isel.daw.LI61N.g10.dawproject.Helpers.ReturningData

interface IUsersCore {

    fun getUser(user_id: Int?): ReturningData<UserOM>

    fun createUser(user: UserIM): ReturningData<UserOM>

    fun deleteUser(id: Int?): ReturningData<UserOM>

    fun getUser(username: String): ReturningData<UserOM>
}