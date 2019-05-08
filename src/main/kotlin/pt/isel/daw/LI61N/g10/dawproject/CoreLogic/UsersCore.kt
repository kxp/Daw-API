package pt.isel.daw.LI61N.g10.dawproject.CoreLogic

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.UserIM
import pt.isel.daw.LI61N.g10.dawproject.CoreLogic.Contracts.IUsersCore
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Contracts.IUserDataAccess
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Models.User
import pt.isel.daw.LI61N.g10.dawproject.Helpers.MessageCode
import pt.isel.daw.LI61N.g10.dawproject.Helpers.ReturningData

@Service
class UsersCore : IUsersCore {

    @Autowired
    private val userRepository: IUserDataAccess? = null

    override fun getUser(user_id: Int?): ReturningData<User> {
        var returningData : ReturningData<User>
        try {
            val user = userRepository!!.getUser(user_id)
            returningData = ReturningData<User>(MessageCode.Ok, user)
        }
        catch (e:Exception)
        {
            returningData =  ReturningData<User>(MessageCode.GenericError, null)
        }
        return returningData
    }

    override fun createUser(user: UserIM): ReturningData<User> {
        try {
            val user = userRepository!!.createUser(User(user.id, user.username, user.password))
            return ReturningData<User>(MessageCode.Ok, user)
        }
        catch (e:Exception)
        {
            return ReturningData<User>(MessageCode.GenericError, null)
        }
    }

    override fun deleteUser(id: Int?) {
        try {
            userRepository!!.deleteUser(id)
        }
        catch (e:Exception)
        {
        }
    }

    override fun getUser(username: String): ReturningData<User> {
        var returningData : ReturningData<User>
        try {
            val user = userRepository!!.getUser(username)
            returningData = ReturningData<User>(MessageCode.Ok, user)
        }
        catch (e:Exception)
        {
            returningData =  ReturningData<User>(MessageCode.GenericError, null)
        }
        return returningData
    }
}