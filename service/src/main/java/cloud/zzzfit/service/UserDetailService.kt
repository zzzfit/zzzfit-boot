package cloud.zzzfit.service

import org.springframework.security.core.userdetails.UserDetails


class UserDetailService : org.springframework.security.core.userdetails.UserDetailsService {
    override fun loadUserByUsername(username: String?): UserDetails {
        TODO("Not yet implemented")
    }
}
