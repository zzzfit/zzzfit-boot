package cloud.zzzfit.upms

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.hibernate.HibernateException
import org.hibernate.cfg.Environment
import org.hibernate.context.spi.CurrentTenantIdentifierResolver
import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.orm.jpa.JpaVendorAdapter
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.servlet.ModelAndView
import java.sql.Connection
import java.sql.SQLException
import javax.sql.DataSource


object TenantContext {
    private val value = ThreadLocal<String?>()
    fun setCurrentTenant(tenant: String) {
        value.set(tenant)
    }

    fun getCurrentTenant(): String? {
        return value.get()
    }

    fun clear() {
        value.set(null)
    }
}

@Component
class TenantIdentifierResolver : CurrentTenantIdentifierResolver {
    override fun resolveCurrentTenantIdentifier(): String {
        return TenantContext.getCurrentTenant() ?: DEFAULT_TENANT_ID
    }

    override fun validateExistingCurrentSessions(): Boolean {
        return true
    }

    companion object {
        const val DEFAULT_TENANT_ID = "tenant_0"
    }
}

@Component
class TenantInterceptor : HandlerInterceptor {
    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        val tenantId = request.getHeader("X-TenantId")
        TenantContext.setCurrentTenant("tenant_$tenantId")
        return true
    }

    override fun postHandle(
        request: HttpServletRequest,
        response: HttpServletResponse, handler: Any, modelAndView: ModelAndView?
    ) {
        TenantContext.clear()
    }
}


@Component
class MultiTenantConnectionProviderImpl(@Qualifier("dataSource") private val dataSource: DataSource) :
    MultiTenantConnectionProvider {

    @Throws(SQLException::class)
    override fun getAnyConnection(): Connection? = dataSource.connection

    @Throws(SQLException::class)
    override fun releaseAnyConnection(connection: Connection?) {
        connection?.close()
    }

    @Throws(SQLException::class)
    override fun getConnection(tenantIdentifier: String): Connection? {
//        var tenantIdentifier: String? = tenantIdentifier
//        tenantIdentifier = TenantContext.getCurrentTenant()
//        val connection = anyConnection
        try {
            val id = TenantContext.getCurrentTenant() ?: TenantIdentifierResolver.DEFAULT_TENANT_ID
            anyConnection?.createStatement()?.execute("USE $id")
        } catch (e: SQLException) {
            throw HibernateException(
                "Problem setting schema to $tenantIdentifier",
                e
            )
        }
        return anyConnection
    }

    @Throws(SQLException::class)
    override fun releaseConnection(tenantIdentifier: String, connection: Connection) {
        try {
            connection.createStatement().execute("USE " + TenantIdentifierResolver.DEFAULT_TENANT_ID)
        } catch (e: SQLException) {
            throw HibernateException(
                "Problem setting schema to $tenantIdentifier",
                e
            )
        }
        connection.close()
    }

    override fun isUnwrappableAs(unwrapType: Class<*>?): Boolean {
        return false
    }

    override fun <T> unwrap(unwrapType: Class<T>): T? {
        return null
    }

    override fun supportsAggressiveRelease(): Boolean {
        return true
    }
}


@Configuration
open class HibernateConfig(private val jpaProperties: JpaProperties) {
    @Bean
    open fun jpaVendorAdapter(): JpaVendorAdapter {
        return HibernateJpaVendorAdapter()
    }

    @Bean
    fun entityManagerFactory(
        @Qualifier("dataSource") dataSource: DataSource,
        provider: MultiTenantConnectionProvider,
        resolver: CurrentTenantIdentifierResolver
    ): LocalContainerEntityManagerFactoryBean {
        val properties = HashMap<String, Any>(jpaProperties.properties)
        properties[Environment.MULTI_TENANT_CONNECTION_PROVIDER] = provider
        properties[Environment.MULTI_TENANT_IDENTIFIER_RESOLVER] = resolver
        val em = LocalContainerEntityManagerFactoryBean()
        em.setDataSource(dataSource)
//        em.setPackagesToScan("com.你的包.erp")
        em.jpaVendorAdapter = jpaVendorAdapter()
        em.jpaPropertyMap = properties
        return em
    }
}