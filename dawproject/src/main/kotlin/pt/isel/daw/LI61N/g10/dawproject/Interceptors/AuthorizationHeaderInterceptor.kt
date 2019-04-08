package pt.isel.daw.LI61N.g10.dawproject.Interceptors

import org.apache.tomcat.util.codec.binary.Base64
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.servlet.ModelAndView
import pt.isel.daw.LI61N.g10.dawproject.CoreLogic.Contracts.IUsersCore
import pt.isel.daw.LI61N.g10.dawproject.Helpers.MessageCode
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class AuthorizationHeaderInterceptor : HandlerInterceptor {

    private val HEADER_AUTHORIZATION = "WWW-Authenticate"

    @Autowired
    private val userLogic: IUsersCore? = null

    override fun preHandle(
            request: HttpServletRequest,
            response: HttpServletResponse,
            handler: Any): Boolean {
            val authUsername64 = request.getHeader(HEADER_AUTHORIZATION)
            if(authUsername64 != null)
            {
                val usernameBytes = Base64.decodeBase64(authUsername64)
                val user = userLogic!!.getUser(String(usernameBytes))
                return user.Data != null && user.MessageCode == MessageCode.Ok
            }
            return false
    }
}