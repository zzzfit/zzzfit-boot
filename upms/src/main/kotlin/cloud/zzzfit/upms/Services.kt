package cloud.zzzfit.upms

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.AuthenticationServiceException
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.core.Authentication
import org.springframework.security.oauth2.core.AbstractOAuth2Token
import org.springframework.security.oauth2.server.resource.authentication.AbstractOAuth2TokenAuthenticationToken
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter
import org.springframework.security.web.util.matcher.AntPathRequestMatcher


class MobileToken(private val tokenValue: String) : AbstractOAuth2Token(tokenValue)

class MobileAuthenticationToken(private val token: MobileToken) :
    AbstractOAuth2TokenAuthenticationToken<MobileToken>(token) {
    override fun getTokenAttributes(): MutableMap<String, Any> {
        TODO("Not yet implemented")
    }
}

class MobileAuthenticationProvider(private val code: String) : AuthenticationProvider {
    override fun authenticate(authentication: Authentication): Authentication? {
        if (!supports(authentication.javaClass)) {
            return null
        }
        if (code != ((authentication as? MobileAuthenticationToken)?.token ?: "")) {
            throw BadCredentialsException("The presented MobileAuthenticationProvider does not contain the expected code")
        }
        return authentication
    }

    override fun supports(authentication: Class<*>): Boolean {
        return MobileAuthenticationToken::class.java.isAssignableFrom(authentication)
    }
}

class MobileAuthenticationProcessingFilter(
    authenticationManager: AuthenticationManager
) : AbstractAuthenticationProcessingFilter(AntPathRequestMatcher("/login", "POST"), authenticationManager) {
    private val postOnly = true

    override fun attemptAuthentication(request: HttpServletRequest, response: HttpServletResponse): Authentication {
        if (postOnly && request.method != "POST") {
            throw AuthenticationServiceException("Authentication method not supported: " + request.method)
        }
        var token = request.getParameter("mobile")
        token = token?.trim { it <= ' ' } ?: ""
        val authRequest = MobileAuthenticationToken(MobileToken(token))
//        authRequest.details = token
        return authenticationManager.authenticate(authRequest)
    }
}