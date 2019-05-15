package pt.isel.daw.LI61N.g10.dawproject.CoreLogic

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.UserIM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.OutputModels.UserOM
import pt.isel.daw.LI61N.g10.dawproject.CoreLogic.Contracts.IUsersCore
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Contracts.IUserDataAccess
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Models.User
import pt.isel.daw.LI61N.g10.dawproject.Helpers.MessageCode
import pt.isel.daw.LI61N.g10.dawproject.Helpers.ReturningData

@Service
class UsersCore : IUsersCore {

    @Autowired
    private val userRepository: IUserDataAccess? = null

    override fun getUser(user_id: Int?): ReturningData<UserOM> {
        val user = userRepository!!.getUser(user_id)
        if(user!=null)
        {
            return ReturningData<UserOM>(MessageCode.Ok, UserOM(user.id, user.username))
        }
        return ReturningData<UserOM>(MessageCode.ProjectNotFound, null )
    }

    override fun createUser(user: UserIM): ReturningData<UserOM> {
        var user = userRepository!!.createUser(User(user.id, user.username, user.password))

        if(user != null){
            return ReturningData<UserOM>(MessageCode.Ok, UserOM(user.id, user.username))
        }
        else
        {
            return ReturningData<UserOM>(MessageCode.GenericError, null)
        }
    }

    override fun deleteUser(id: Int?): ReturningData<UserOM> {
        var deleted = userRepository!!.deleteUser(id)
        if(deleted > 0){
            return ReturningData<UserOM>(MessageCode.Ok, null )
        }
        return ReturningData<UserOM>(MessageCode.ProjectNotFound, null)
    }

    override fun getUser(username: String): ReturningData<UserOM> {
        val user = userRepository!!.getUser(username)
        if(user!=null)
        {
            return ReturningData<UserOM>(MessageCode.Ok, UserOM(user.id, user.username))
        }
        return ReturningData<UserOM>(MessageCode.ProjectNotFound, null )
    }
}