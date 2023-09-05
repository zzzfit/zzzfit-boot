package cloud.zzzfit.web.service

import cloud.zzzfit.data.entity.User
import cloud.zzzfit.data.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AccountService {

    @Autowired
    private lateinit var userRepository: UserRepository

    fun login(username: String, password: String): User? {
       val found = userRepository.findByUsernameAndPassword(username, password)
        return found
    }
}