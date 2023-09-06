package cloud.zzzfit.web.service.impl

import cloud.zzzfit.data.entity.User
import cloud.zzzfit.data.repository.UserRepository
import cloud.zzzfit.web.service.AccountService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AccountServiceImpl: AccountService {

    @Autowired
    private lateinit var userRepository: UserRepository

    override fun login(username: String, password: String): User? {
       val found = userRepository.findByUsernameAndPassword(username, password)
        return found
    }
}