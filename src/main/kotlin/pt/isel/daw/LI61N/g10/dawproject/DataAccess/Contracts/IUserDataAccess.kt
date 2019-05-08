package pt.isel.daw.LI61N.g10.dawproject.DataAccess.Contracts

import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Models.User
import pt.isel.daw.LI61N.g10.dawproject.Helpers.ReturningData

interface IUserDataAccess {

    fun getUser(user_id: Int?): User?

    fun createUser(user: User): User?

    fun deleteUser(id: Int?)

    fun getUser(username: String): User?
}