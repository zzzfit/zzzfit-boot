package cloud.zzzfit.data.repository

//import org.springframework.data.querydsl.QuerydslPredicateExecutor
import cloud.zzzfit.data.entity.*
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.querydsl.QuerydslPredicateExecutor
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer
import org.springframework.stereotype.Repository

interface UserRepository : JpaRepository<User, Long> {
    fun findByUsername(username: String, pageable: Pageable): Page<User>


}


interface DianRepository : JpaRepository<Dian, Long> {
    fun findByName(name: String): Dian?
}
//    ,
//    QuerydslPredicateExecutor<Dian> {}
//
//interface TenantRepository : JpaRepository<Tenant, Long>
////    ,
////    QuerydslPredicateExecutor<Tenant> {}
//
//interface AllianceRepository : JpaRepository<Alliance, Long>
////    ,
////    QuerydslPredicateExecutor<Alliance> {}
interface OrganizationRepository : JpaRepository<Organization, Long>
//    , QuerydslPredicateExecutor<Organization>, QuerydslBinderCustomizer<QOrganization> {}

