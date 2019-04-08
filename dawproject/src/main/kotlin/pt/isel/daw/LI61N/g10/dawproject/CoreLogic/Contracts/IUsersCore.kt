package pt.isel.daw.LI61N.g10.dawproject.CoreLogic.Contracts

import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.UserIM
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Models.User
import pt.isel.daw.LI61N.g10.dawproject.Helpers.ReturningData

interface IUsersCore {

    fun getUser(user_id: Int?): ReturningData<User>

    fun createUser(user: UserIM): ReturningData<Int>

    fun deleteUser(id: Int?)

    fun getUser(username: String): ReturningData<User>
}