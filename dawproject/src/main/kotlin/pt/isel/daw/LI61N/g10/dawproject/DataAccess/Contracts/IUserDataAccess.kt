package pt.isel.daw.LI61N.g10.dawproject.DataAccess.Contracts

import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Models.User

interface IUserDataAccess {

    fun getUser(user_id: Int?): User?

    fun createUser(user: User): Int

    fun deleteIssue(id: Int?)
}