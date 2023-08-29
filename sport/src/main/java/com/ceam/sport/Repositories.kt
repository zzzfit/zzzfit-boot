package com.ceam.sport

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.geo.Distance
import org.springframework.data.geo.Point
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.querydsl.QuerydslPredicateExecutor
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.data.rest.core.annotation.RestResource
import org.springframework.data.rest.core.config.Projection
import org.springframework.data.rest.core.support.EntityLookupSupport
import org.springframework.stereotype.Component
import java.util.*


@RepositoryRestResource(excerptProjection = CustomerExcerpt::class)
interface CustomerRepository : JpaRepository<Customer, Long>

interface OrderRepository : JpaRepository<Order, Long>

@Projection(name = "excerpt", types = [Customer::class])
interface CustomerExcerpt {
    val firstname: String?
    val lastname: String?

//    @get:Value("#{target.address.toString()}")
    val address: String?
}


interface StoreRepository : JpaRepository<Store, Long>,
    QuerydslPredicateExecutor<Store?> {
    @RestResource(rel = "by-location")
    fun findByAddressLocationNear(location: Point, distance: Distance, pageable: Pageable): Page<Store>

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


interface UserRepository : JpaRepository<User, Long> {
    /**
     * Looks up a unique [User] by its user name.
     *
     * @param username
     * @return
     */
    fun findByUsername(username: String): Optional<User>
}
@Component
class StoreInitializer {

    lateinit var repository: StoreRepository


    fun initialize( )
    {

    }
}

//
//class UserEntityLookup : EntityLookupSupport<User>() ,QuerydslPredicateExecutor<User>, QuerydslBinderCustomizer<QUser> {
//
//     lateinit var repository: UserRepository
//
//    /*
//	 * (non-Javadoc)
//	 * @see org.springframework.data.rest.core.support.EntityLookup#getId(java.lang.Object)
//	 */
//    override fun getResourceIdentifier(entity: User): Any {
//        return entity.username!!
//    }
//
//    /*
//	 * (non-Javadoc)
//	 * @see org.springframework.data.rest.core.support.EntityLookup#lookupEntity(java.lang.Object)
//	 */
//    override fun lookupEntity(id: Any): Optional<User> {
//        return repository.findByUsername(id.toString())
//    }
//
//    /*
//	 * (non-Javadoc)
//	 * @see org.springframework.data.rest.core.support.EntityLookup#getLookupProperty()
//	 */
//    override fun getLookupProperty(): Optional<String> {
//        return Optional.of("username")
//    }
//}