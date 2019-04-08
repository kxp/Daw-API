package pt.isel.daw.LI61N.g10.dawproject.CoreLogic

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.*
import pt.isel.daw.LI61N.g10.dawproject.CoreLogic.Contracts.*
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Contracts.*
import pt.isel.daw.LI61N.g10.dawproject.DataAccess.Models.Transition
import pt.isel.daw.LI61N.g10.dawproject.Helpers.MessageCode
import pt.isel.daw.LI61N.g10.dawproject.Helpers.ReturningData

@Service
public class UserValidation   {

    //Static object, type singleton
    @Service
    companion object {

        @Autowired
        private val userRepository: IUserDataAccess? = null

        fun Validate(auth: AuthIM): Boolean {

            //TODO: validate  the encode64
            //var user = userRepository!!.getUser(2)
            return true
        }
    }
}