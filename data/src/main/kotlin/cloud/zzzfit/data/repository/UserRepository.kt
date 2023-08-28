package cloud.zzzfit.data.repository

import cloud.zzzfit.data.entity.Alliance
import cloud.zzzfit.data.entity.Dian
import cloud.zzzfit.data.entity.Tenant
import cloud.zzzfit.data.entity.User
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.querydsl.QuerydslPredicateExecutor
import org.springframework.data.repository.PagingAndSortingRepository

interface UserRepository : PagingAndSortingRepository<User, Long>,
    QuerydslPredicateExecutor<User> {
    fun findByUsername(username: String, pageable: Pageable): Page<User>

    /**
     * Tweak the Querydsl binding if collection resources are filtered.
     *
     * @see org.springframework.data.web.querydsl.QuerydslBinderCustomizer.customize
     */
//    fun customize(bindings: QuerydslBindings, store: QStore) {
//        bindings.bind(store.address.city).first(StringExpression::endsWith)
//        bindings.bind<String>(String::class.java)
//            .first(StringExpression::contains as SingleValueBinding<StringPath?, String>?)
//    }
}

interface DianRepository : PagingAndSortingRepository<Dian, Long>,
    QuerydslPredicateExecutor<Dian> {}

interface TenantRepository : PagingAndSortingRepository<Tenant, Long>,
    QuerydslPredicateExecutor<Tenant> {}

interface AllianceRepository : PagingAndSortingRepository<Alliance, Long>,
    QuerydslPredicateExecutor<Alliance> {}