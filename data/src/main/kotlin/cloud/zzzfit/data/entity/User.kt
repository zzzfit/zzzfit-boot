package cloud.zzzfit.data.entity

import jakarta.persistence.*
import org.hibernate.annotations.Comment
import org.hibernate.annotations.Fetch
import org.hibernate.annotations.FetchMode
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.io.Serializable
import java.math.BigDecimal
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
class Role: Managed() {
    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    val authorities: Set<Authority> = HashSet<Authority>()

}

@Entity
class Authority: Managed() {

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

    @OneToOne
    @MapsId
    var detail: UserDetail? = null


    @ManyToMany(fetch = FetchType.EAGER)
    val roles: Set<Role> = HashSet<Role>()
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


@Entity
class Invoice {
    @Id
    @GeneratedValue
    var id: Long? =null

    @Column(nullable = false, length = 16)
    var number: String? = null

    @Column(name="paid_amount", nullable = false, precision = 12, scale = 2)
    var paidAmount: BigDecimal? = null

    @Column(name="download_link")
    var downloadLink: String? = null
}

@Entity
class Course {
    @Id
    @GeneratedValue
    var id: Long? =null

    var tags: String? = null
}

@Entity
class Payment {
    @Id
    @GeneratedValue
    var id: Long? =null
}

@Entity
class Order {
    @Id
    @GeneratedValue
    var id: Long? =null
}

@Entity
class Coupon {
    @Id
    @GeneratedValue
    var id: Long? =null
}

@Entity
class Campaign {
    @Id
    @GeneratedValue
    var id: Long? =null
}

@Entity
class Lead {
    @Id
    @GeneratedValue
    var id: Long? =null
}

@Entity
class Contract {
    @Id
    @GeneratedValue
    var id: Long? =null
}

@Entity
class Staff {
    @Id
    @GeneratedValue
    var id: Long? =null
}

@Entity
class Member {
    @Id
    @GeneratedValue
    var id: Long? =null
}

@Entity
class Device {
    @Id
    @GeneratedValue
    var id: Long? =null
}

@Entity
@Embeddable
class Address {
    @Id
    @GeneratedValue
    var id: Long? =null

    var province: String? = null

    var city:String? =null

    var district: String? = null

    var street: String? =null

    @Column(name = "postal_code")
    var postalCode: String? = null

    var longitude: Double?=null

    var latitude: Double?=null
}

@Entity
class MemberCard {
    enum class Type {
        OneShot,
        Period,
        PrePaid,
    }
    enum class Period {
        OneWeek,
        OneMonth,
        TweMonth,
        OneSeason,
        HalfYear,
        OneYear,
        TwoYear,
        ThreeYear,
        FiveYear,
        TenYear
    }

    enum class Status {
        Activated,
        Expired,
        Cancelled,
    }

    @Id
    @GeneratedValue
    var id: Long? =null

    @Temporal(TemporalType.DATE)
    var startDate: Date? = null

    @Temporal(TemporalType.DATE)
    var endDate: Date? = null

    @Column(precision = 12, scale = 2)
    var paidAmount: BigDecimal? = null
}

@Entity
class Voucher {
    @Id
    @GeneratedValue
    var id: Long? =null
}

@Entity
class Class {

    enum class Type {
        OneVsOne,
        OneVsTwo,
        OneVsThree
    }

    @Id
    @GeneratedValue
    var id: Long? =null

    @OneToMany
    var teachers: Set<Staff> = HashSet()

    @OneToMany
    var attendants: Set<Member> = HashSet()
}

@Entity
class Attendance {
    @Id
    @GeneratedValue
    var id: Long? =null

    @OneToOne
    var `class`: Class?=null

    @Temporal(TemporalType.TIMESTAMP)
    var checkInTime: Timestamp? = null
}

@Entity
class Appointment {
    @Id
    @GeneratedValue
    var id: Long? =null

    @OneToOne
    var `class`: Class?=null

}