package cloud.zzzfit.data.entity

import jakarta.persistence.*
import org.hibernate.annotations.Comment
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.io.Serializable
import java.sql.Date
import java.sql.Timestamp


@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class Audited<T : Serializable> {
    companion object {
        private const val serialVersionUID = -1L
    }

    @Id
    @GeneratedValue
    @Comment("id")
    var id: T? = null

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    var createdAt: Date? = null

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    val updatedAt: Date? = null

    @CreatedBy
    @Column(nullable = false, updatable = false)
    val createdBy: T? = null

    @LastModifiedBy
    @Column(nullable = false)
    val updatedBy: T? = null
}

@MappedSuperclass
@Table(indexes = [Index(columnList = "tenantId")])
abstract class Managed : Audited<Long>() {
    @Column(nullable = false)
    var tenantId: Long = 0

    @Column(nullable = false, length = 63)
    var name: String? = null

    @Column(length = 255)
    var description: String? = null

    @Column
    var deleted: Boolean = false
}

@Entity
class Organization : Managed()

@Entity
@Table(
    uniqueConstraints = [UniqueConstraint(columnNames = ["name"])]
)
class Tenant : Managed()

@Entity
@Table(
    indexes = [
        Index(name = "username", columnList = "username"),
        Index(name = "mobile", columnList = "mobile")
    ]
)
class User : Managed() {
    var nickname: String? = null
    var password: String? = null
}

@Entity
class UserDetail : Managed()

@Entity
class Dian : Managed() {

    @Column(nullable = false)
    @ManyToOne
    var alliance: Alliance? = null

    @Column(name = "shop_area")
    var shopArea: Float? = null

    @Column(name = "business_hour")
    @Embedded
    @AttributeOverrides(
        AttributeOverride(name = "start", column = Column(name = "business_hour_start")),
        AttributeOverride(name = "endDate", column = Column(name = "business_hour_end"))
    )
    var businessHour: BusinessHour? = null
}

@Entity
class Franchisee : Managed()

@Entity
class Alliance : Managed() {

    @OneToMany
    var dians: Collection<Dian>? = null
}

@Entity
@Embeddable
class BusinessHour : Managed() {

    @Temporal(TemporalType.TIME)
    var start: Timestamp? = null

    @Temporal(TemporalType.TIME)
    var end: Timestamp? = null
}