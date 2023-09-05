package cloud.zzzfit.data.entity

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.io.Serializable
import java.math.BigDecimal
import java.sql.Date
import java.sql.Time
import java.sql.Timestamp


@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class Audited<T : Serializable> {

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    var createdAt: Timestamp? = null

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    var updatedAt: Timestamp? = null

    @CreatedBy
    @Column(updatable = false)
    var createdBy: T? = null

    @LastModifiedBy
    var updatedBy: T? = null
}

@MappedSuperclass
abstract class Managed<T : Serializable> : Audited<T>() {

    @Column(length = 255)
    var description: String? = null

    @Column
    var deleted: Boolean = false
}

@Entity
class Role : Managed<Long>() {

    @Id
    @GeneratedValue
    var id: Long = 0

    @Column(length = 63, unique = true, nullable = false)
    var name: String? = null

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "role_authority",
        joinColumns = [JoinColumn(name = "role_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "authority_id", referencedColumnName = "id")]
    )
    var authorities: MutableSet<Authority> = HashSet()
}

@Entity
class Authority : Managed<Long>() {

    @Id
    @GeneratedValue
    var id: Long = 0

    @Column(length = 63, unique = true, nullable = false)
    var name: String? = null
}

@Entity
class Organization : Managed<Long>() {

    @Id
    @GeneratedValue
    var id: Long = 0

    @Column(length = 63, unique = true, nullable = false)
    var name: String? = null

    @OneToMany(mappedBy = "parent")
    var children: MutableList<Organization>? = null

    @ManyToOne
    var parent: Organization? = null

    @Column(nullable = false)
    var ownedBy: Long? = null
}

//@Entity
//class Tenant : Managed<Long>() {
//    @Id
//    @GeneratedValue
//    var id: Long = 0
//
//    @Column(length = 63, unique = true, nullable = false)
//    var name: String? = null
//}

@Entity
@Table(
    indexes = [
        Index(columnList = "username"),
        Index(columnList = "mobile"),
        Index(columnList = "email"),
    ]
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
//@DiscriminatorValue("member")
open class User : Managed<Long>() {

    @Id
    @GeneratedValue
    var id: Long = 0

    @Column(length = 63, unique = true, nullable = false)
    var username: String? = null

    @Column(length = 63)
    var nickname: String? = null

    var password: String? = null

    @Column(unique = true, length = 31)
    var mobile: String? = null

    @Column(unique = true, length = 31)
    var email: String? = null

    @Embedded
    var detail: UserDetail? = null

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "user_role",
        joinColumns = [JoinColumn(name = "user_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "role_id", referencedColumnName = "id")]
    )
    var roles: MutableSet<Role> = HashSet()
}

@Embeddable
class UserDetail {

    enum class Gender {
        MALE, FEMALE
    }

    @Enumerated(EnumType.ORDINAL)
    var gender: Gender? = null

    @Temporal(TemporalType.DATE)
    var birthday: Date? = null

    var avatarUrl: String? = null
}

@Entity
class Dian : Managed<Long>() {

    enum class Status {
        OpeningSoon,
        InBusiness,
        InSuspension,
        ClosedDown
    }


    @Id
    @GeneratedValue
    var id: Long = 0

    @Column(length = 63, nullable = false)
    var name: String? = null

//    @Column(nullable = false)
//    @ManyToOne
//    var alliance: Alliance? = null

    @Column(name = "shop_area")
    var shopArea: Float? = null

    @Column(name = "status")
    var status: Status? = null

    @Column(name = "business_hour_start")

    @Temporal(TemporalType.TIME)
    var businessHourStart: Time? = null

    @Column(name = "business_hour_end")
    @Temporal(TemporalType.TIME)
    var businessHourEnd: Time? = null

    @Column(name = "equipment_info")
    var equipmentInfo: String? = null
}

@Entity
class Franchisee : Managed<Long>() {
    @Id
    @GeneratedValue
    var id: Long = 0
}

@Entity
class Alliance : Managed<Long>() {

    @Id
    @GeneratedValue
    var id: Long = 0

//    @OneToMany
//    var dians: Collection<Dian> = HashSet()
}

@Entity
class Invoice {
    @Id
    @GeneratedValue
    var id: Long = 0

    @Column(nullable = false, length = 16)
    var number: String? = null

    @Column(name = "paid_amount", nullable = false, precision = 12, scale = 2)
    var paidAmount: BigDecimal? = null

    @Column(name = "download_link")
    var downloadLink: String? = null
}

@Entity
class Course {
    @Id
    @GeneratedValue
    var id: Long = 0

    var tags: String? = null
}

@Entity
class Payment {
    @Id
    @GeneratedValue
    var id: Long = 0
}

@Entity
class Order {
    @Id
    @GeneratedValue
    var id: Long = 0
}

@Entity
class Coupon {
    @Id
    @GeneratedValue
    var id: Long = 0
}

@Entity
class Campaign {
    @Id
    @GeneratedValue
    var id: Long = 0
}

@Entity
class Lead {
    @Id
    @GeneratedValue
    var id: Long = 0
}

@Entity
class Contract {
    @Id
    @GeneratedValue
    var id: Long = 0
}

@Entity
@DiscriminatorValue("member")
class Member : User() {
    @Column(name="member_id")
    var memberId: String? = null
}

@Entity
@DiscriminatorValue("coach")
class Coach : User() {
    @Column(name="coach_id")
    var coachId: String? = null

    @Column(name="image_urls")
    var imageUrls: String? = null
}


@Entity
@DiscriminatorValue("store")
class Store : User() {
    @Column(name="store_id")
    var storeId: String? = null
}

@Entity
class Device {
    @Id
    @GeneratedValue
    var id: Long = 0
}

@Entity
@Embeddable
class Address {
    @Id
    @GeneratedValue
    var id: Long = 0

    var province: String? = null

    var city: String? = null

    var district: String? = null

    var street: String? = null

    @Column(name = "postal_code")
    var postalCode: String? = null

    var longitude: Double? = null

    var latitude: Double? = null
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
    var id: Long? = null

    @Temporal(TemporalType.DATE)
    var startDate: Date? = null

    @Temporal(TemporalType.DATE)
    var endDate: Date? = null

    @Column(precision = 12, scale = 2)
    var paidAmount: BigDecimal? = null

//    @Column(name = "applicable_dian")
//    var applicableDians: Set<Dian>? = HashSet()
}

@Entity
class Voucher {
    @Id
    @GeneratedValue
    var id: Long = 0
}

//@Entity
//class Class {
//
//    enum class Type {
//        OneVsOne,
//        OneVsTwo,
//        OneVsThree
//    }
//
//    @Id
//    @GeneratedValue
//    var id: Long? = null
//
//    @OneToMany
//    var teachers: MutableSet<Coach> = HashSet()
//
//    @OneToMany
//    var attendants: MutableSet<Member> = HashSet()
//}

@Entity
class Attendance {
    @Id
    @GeneratedValue
    var id: Long = 0

//    @OneToOne
//    var `class`: Class? = null

    @Temporal(TemporalType.TIMESTAMP)
    var checkInTime: Timestamp? = null
}

@Entity
class Appointment {
    @Id
    @GeneratedValue
    var id: Long = 0

//    @OneToOne
//    var `class`: Class? = null
}

@Entity
class Invitation : Managed<Long>() {
    @Id
    @GeneratedValue
    var id: Long = 0

    @Column(nullable = false)
    @Temporal(TemporalType.TIME)
    var `when`: Time? = null
}
