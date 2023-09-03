package cloud.zzzfit.web.service

import cloud.zzzfit.data.repository.DianRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DianService {
    @Autowired
    lateinit var dianRepository: DianRepository

    fun get(name: String) {
       val dian=  dianRepository.findByName(name)
    }
}