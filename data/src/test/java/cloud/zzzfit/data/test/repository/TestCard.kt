package cloud.zzzfit.data.test.repository

import cloud.zzzfit.data.entity.MemberCard
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import java.sql.Date
import java.time.LocalDateTime

//import cloud.zzzfit.data.entity.Dian
//import cloud.zzzfit.data.repository.DianRepository
//import cloud.zzzfit.data.repository.OrganizationRepository
//import org.assertj.core.api.Assertions.*
//import org.junit.jupiter.api.Test
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
//import org.springframework.orm.hibernate5.HibernateCallback

class TestCard {

    @BeforeAll
    fun setup() {
        val card = MemberCard()
        card.startDate = Date.valueOf("2023-01-01")
        card.endDate = Date.valueOf("2023-01-31")
     }
    @Test
    fun should_find_no_tutorials_if_repository_is_empty() {
//        val tutorials  = dianRepository.findAll()
//        Assertions.assertThat(tutorials).isEmpty()
    }
}