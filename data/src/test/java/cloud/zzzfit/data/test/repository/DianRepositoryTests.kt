package cloud.zzzfit.data.test.repository

import cloud.zzzfit.data.repository.DianRepository
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

//@DataJpaTest
//class DianRepositoryTests(
//    @Autowired val entityManager: TestEntityManager,
////    @Autowired dianRepository: DianRepository,
//) {
//
//    @Autowired
//    private lateinit var dianRepository: DianRepository
//
//    @Test
//    fun test11() {
////        val user = Dian()
////        user.setDisplayName("Chinna")
////        user.setEmail("java4chinna@gmail.com")
////        // Add a role to the user
////        // Add a role to the user
////        val adminRole: Role = roleRepository.findByName(Role.ROLE_ADMIN)
////        user.addRole(roleRepository.findByName(Role.ROLE_USER))
////        user.addRole(adminRole)
////        user = userRepository.saveAndFlush(user)
////        assertEquals(2, user.getRoles().size())
//        assertTrue(true)
//    }
//
////    @Test
////    fun testExample() {
////        entityManager.persist(User("sboot", "1234"))
////        val user = repository.findByUsername("sboot")
////        assertThat(user?.username).isEqualTo("sboot")
////        assertThat(user?.employeeNumber).isEqualTo("1234")
////    }
//}

@DataJpaTest
class DianRepositoryTests {
    @Autowired
    lateinit var entityManager: TestEntityManager

    @Autowired
    lateinit var dianRepository: DianRepository
    @Test
    fun should_find_no_tutorials_if_repository_is_empty() {
        val tutorials  = dianRepository.findAll()
        Assertions.assertThat(tutorials).isEmpty()
    }

//    @Test
//    fun should_store_a_tutorial() {
//        val tutorial = repository!!.save(Tutorial("Tut title", "Tut desc", true))
//        Assertions.assertThat(tutorial).hasFieldOrPropertyWithValue("title", "Tut title")
//        Assertions.assertThat(tutorial).hasFieldOrPropertyWithValue("description", "Tut desc")
//        Assertions.assertThat(tutorial).hasFieldOrPropertyWithValue("published", true)
//    }
//
//    @Test
//    fun should_find_all_tutorials() {
//        val tut1 = Tutorial("Tut#1", "Desc#1", true)
//        entityManager!!.persist(tut1)
//        val tut2 = Tutorial("Tut#2", "Desc#2", false)
//        entityManager.persist(tut2)
//        val tut3 = Tutorial("Tut#3", "Desc#3", true)
//        entityManager.persist(tut3)
//        val tutorials: Iterable<Tutorial?> = repository!!.findAll()
//        Assertions.assertThat(tutorials).hasSize(3).contains(tut1, tut2, tut3)
//    }
//
//    @Test
//    fun should_find_tutorial_by_id() {
//        val tut1 = Tutorial("Tut#1", "Desc#1", true)
//        entityManager!!.persist(tut1)
//        val tut2 = Tutorial("Tut#2", "Desc#2", false)
//        entityManager.persist(tut2)
//        val foundTutorial = repository!!.findById(tut2.id).get()
//        Assertions.assertThat(foundTutorial).isEqualTo(tut2)
//    }
//
//    @Test
//    fun should_find_published_tutorials() {
//        val tut1 = Tutorial("Tut#1", "Desc#1", true)
//        entityManager!!.persist(tut1)
//        val tut2 = Tutorial("Tut#2", "Desc#2", false)
//        entityManager.persist(tut2)
//        val tut3 = Tutorial("Tut#3", "Desc#3", true)
//        entityManager.persist(tut3)
//        val tutorials: Iterable<Tutorial?>? = repository!!.findByPublished(true)
//        Assertions.assertThat(tutorials).hasSize(2).contains(tut1, tut3)
//    }
//
//    @Test
//    fun should_find_tutorials_by_title_containing_string() {
//        val tut1 = Tutorial("Spring Boot Tut#1", "Desc#1", true)
//        entityManager!!.persist(tut1)
//        val tut2 = Tutorial("Java Tut#2", "Desc#2", false)
//        entityManager.persist(tut2)
//        val tut3 = Tutorial("Spring Data JPA Tut#3", "Desc#3", true)
//        entityManager.persist(tut3)
//        val tutorials: Iterable<Tutorial?>? = repository!!.findByTitleContaining("ring")
//        Assertions.assertThat(tutorials).hasSize(2).contains(tut1, tut3)
//    }
//
//    @Test
//    fun should_update_tutorial_by_id() {
//        val tut1 = Tutorial("Tut#1", "Desc#1", true)
//        entityManager!!.persist(tut1)
//        val tut2 = Tutorial("Tut#2", "Desc#2", false)
//        entityManager.persist(tut2)
//        val updatedTut = Tutorial("updated Tut#2", "updated Desc#2", true)
//        val tut = repository!!.findById(tut2.id).get()
//        tut.title = updatedTut.title
//        tut.description = updatedTut.description
//        tut.isPublished = updatedTut.isPublished
//        repository!!.save(tut)
//        val checkTut = repository!!.findById(tut2.id).get()
//        Assertions.assertThat(checkTut.id).isEqualTo(tut2.id)
//        Assertions.assertThat(checkTut.title).isEqualTo(updatedTut.title)
//        Assertions.assertThat(checkTut.description).isEqualTo(updatedTut.description)
//        Assertions.assertThat(checkTut.isPublished).isEqualTo(updatedTut.isPublished)
//    }
//
//    @Test
//    fun should_delete_tutorial_by_id() {
//        val tut1 = Tutorial("Tut#1", "Desc#1", true)
//        entityManager!!.persist(tut1)
//        val tut2 = Tutorial("Tut#2", "Desc#2", false)
//        entityManager.persist(tut2)
//        val tut3 = Tutorial("Tut#3", "Desc#3", true)
//        entityManager.persist(tut3)
//        repository!!.deleteById(tut2.id)
//        val tutorials: Iterable<Tutorial?> = repository!!.findAll()
//        Assertions.assertThat(tutorials).hasSize(2).contains(tut1, tut3)
//    }
//
//    @Test
//    fun should_delete_all_tutorials() {
//        entityManager!!.persist(Tutorial("Tut#1", "Desc#1", true))
//        entityManager.persist(Tutorial("Tut#2", "Desc#2", false))
//        repository!!.deleteAll()
//        Assertions.assertThat(repository!!.findAll()).isEmpty()
//    }
}