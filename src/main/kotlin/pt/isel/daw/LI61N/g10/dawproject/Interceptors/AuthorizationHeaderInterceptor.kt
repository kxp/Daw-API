package pt.isel.daw.LI61N.g10.dawproject.Interceptors

import org.apache.tomcat.util.codec.binary.Base64
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.servlet.HandlerInterceptor
import pt.isel.daw.LI61N.g10.dawproject.CoreLogic.Contracts.IUsersCore
import pt.isel.daw.LI61N.g10.dawproject.Helpers.MessageCode
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class AuthorizationHeaderInterceptor : HandlerInterceptor {

    private val HEADER_AUTHORIZATION = "Authorization"

    @Autowired
    private val userLogic: IUsersCore? = null

    override fun preHandle(
            request: HttpServletRequest,
            response: HttpServletResponse,
            handler: Any): Boolean {
        val usernameBytes = Base64.decodeBase64("dXNlcg==")
        val user = userLogic!!.getUser(String(usernameBytes))

        response.addHeader("Access-Control-Allow-Origin", "*")
        response.addHeader("Access-Control-Allow-Methods", "GET, PUT, POST, DELETE, OPTIONS")

        return user.Data != null && user.MessageCode == MessageCode.Ok

    }
}