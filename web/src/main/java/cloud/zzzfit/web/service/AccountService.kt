package cloud.zzzfit.web.service

import cloud.zzzfit.data.entity.User
interface AccountService {
    fun login(username: String, password: String): User?
}