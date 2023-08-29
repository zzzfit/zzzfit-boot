package com.ceam.sport

import jakarta.persistence.*
import org.hibernate.annotations.Comment
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.math.BigDecimal
import java.sql.Timestamp


@Entity
@Table(name = "ceam_coach")
@Comment("教练表")
@EntityListeners(AuditingEntityListener::class)
class Coach {

    @Id
    @GeneratedValue
    var id: Long? = null

    @Column(length = 63, nullable = false)
    var name: String? = null

    @Column
    var sex: Byte? = null

    @Column
    var age: Byte? = null

    @Column(name = "unit_price")
    var unitPrice: Double? = null

    @Column
    var review: Int? = null

    @Column
    var taught: Int? = null

    @Column
    var teaching: Int? = null

    @Column
    var avatar: String? = null

    @Column
    var attrs: String? = null

    @Column(name="store_id")
    var storeId: Long? = null

    @Column
    var deleted: Boolean? = false

    @Column(length = 32)
    var phone: String? = null

    @Column(name = "add_time")
    var addTime: Timestamp? = null

    @Column(name = "add_by")
    var addBy: Long? = null

    @Column(name = "upd_time")
    var updTime: Timestamp? = null

    @Column(name = "upd_by")
    var updBy: Long? = null

    @Column
    var signature: String? = null
}

@Entity
@Table(name = "ceam_course_plan")
@EntityListeners(AuditingEntityListener::class)
class CoursePlan {

    @Id
    @GeneratedValue
    var id: Long? = null

    @Column(name = "coach_id")
    var coachId: Long? = null

    @Column(name = "course_id")
    var courseId: Long? = null

    @Column(name = "is_open")
    var isOpen: Boolean? = true

    @Column(length = 63, nullable = false)
    var name: String? = null

    @Column(name = "tab_id")
    var tabId: Long? = null

    @Column(name = "start_time")
    var startTime: Timestamp? = null

    @Column(name = "end_time")
    var endTime: Timestamp? = null

    @Column
    var attrs: String? = null

    @Column(name = "is_show")
    var isShow: Boolean? = true

    @Column(length = 18)
    var classroom: String? = null

    @Column
    var appointment: Int? = null

    @Column(name="store_id")
    var storeId: Long? = null
}

@Entity
@Table(name = "ceam_course_tab")
@EntityListeners(AuditingEntityListener::class)
class CourseTab {

    @Id
    @GeneratedValue
    var id: Long? = null

    @Column
    var code: Int? = null
}

@Entity
@Table(name = "ceam_customer")
@EntityListeners(AuditingEntityListener::class)
class Customer {

    @Id
    @GeneratedValue
    var id: Long? = null

    @Column(name = "customer_code")
    var customerCode: String? = null

    @Column(name = "system_type")
    var systemType: Byte? = null

    @Column(name = "alipay_openid")
    var alipayOpenId: String? = null

    @Column(name = "weixin_openid")
    var weixinOpenId: String? = null

    @Column(name = "weixin_unionid")
    var weixinUnionId: String? = null

    @Column(name = "weixin_webOpenid")
    var weixinWebOpenId: String? = null

    @Column(name = "baidu_openid")
    var baiduOpenId: String? = null

    @Column(name = "toutiao_openid")
    var toutiaoOpenId: String? = null

    @Column(name = "toutiao_unionid")
    var toutiaoUnionId: String? = null

    @Column(name = "qq_openid")
    var qqOpenId: String? = null

    @Column(name = "qq_unionid")
    var qqUnionId: String? = null

    @Column(name = "kuaishou_openid")
    var kuaishouOpenid: String? = null

    @Column
    var status: Byte? = null

    @Column(length = 36)
    var salt: String? = null

    @Column
    var pwd: String? = null

    @Column(length = 36)
    var username: String? = null

    @Column(length = 36)
    var nickname: String? = null


    @Column(length = 36)
    var mobile: String? = null

    @Column(length = 36)
    var email: String? = null

    @Column
    var sex: Byte? = null

    @Column
    var avatar: String? = null

    @Column(length = 36)
    var province: String? = null

    @Column(length = 36)
    var city: String? = null

    @Column(length = 36)
    var county: String? = null

    @Column(length = 36)
    var birthday: String? = null

    @Column
    var address: String? = null

    @Column
    var integral: Int? = null


    @Column(name = "locking_integral")
    var lockingIntegral: Int? = null


    @Column
    var deleted: Boolean? = false

    @Column(name = "is_logout")
    var isLogout: Boolean? = false

    @Column(name = "add_time")
    var addTime: Timestamp? = null

    @Column(name = "upd_time")
    var updTime: Timestamp? = null

    @Column(name = "buy_times")
    var buyTimes: Int? = null

    @Column
    var balance: Double? = null

    enum class Gender {
        MALE,
        FEMALE
    }
}

@Entity
@Table(name = "ceam_home_nav")
@EntityListeners(AuditingEntityListener::class)
class HomeNav {

    @Id
    @GeneratedValue
    var id: Long? = null

    @Column(length = 36)
    var navName: String? = null

    @Column
    var icon: String? = null


    @Column(name = "is_show")
    var isShow: Boolean? = false

    @Column
    var deleted: Boolean? = false

    @Column(name = "add_time")
    var addTime: Timestamp? = null

    @Column(name = "add_by")
    var addBy: Long? = null

    @Column(name = "upd_time")
    var updTime: Timestamp? = null

    @Column(name = "upd_by")
    var updBy: Long? = null
}


@Entity
@Table(name = "ceam_lottery_activity")
@EntityListeners(AuditingEntityListener::class)
class LotteryActivity {

    @Id
    @GeneratedValue
    var id: Long? = null

    @Column(length = 36)
    var name: String? = null

    @Column
    @Comment("状态，0禁用，1正常")
    var status: Byte? = null

    @Column(name = "start_time")
    var startTime: Timestamp? = null

    @Column(name = "end_time")
    var endTime: Timestamp? = null

    @Column
    var deleted: Boolean? = false

    @Column(name = "add_time")
    var addTime: Timestamp? = null

    @Column(name = "add_by")
    var addBy: Long? = null

    @Column(name = "upd_time")
    var updTime: Timestamp? = null

    @Column(name = "upd_by")
    var updBy: Long? = null

    @Column
    @Comment("大转盘/宫格份数，6/8")
    var size: Byte? = null

    @Column
    @Comment("参与对象")
    var participate: Byte? = null

    @Column(name="day_limit")
    @Comment("日限")
    var dayLimit: Byte? = null

    @Column(name="week_limit")
    @Comment("日限")
    var weekLimit: Byte? = null

    @Column(name="month_limit")
    @Comment("月限")
    var monthLimit: Byte? = null
}

@Entity
@Table(name = "ceam_lottery_record")
@EntityListeners(AuditingEntityListener::class)
class LotteryRecord {

    @Id
    @GeneratedValue
    var id: Long? = null

    @Column(name = "activity_id")
    @Comment("活动id")
    var activityId: Long? = null

    @Column(name = "customer_id")
    @Comment("客户id")
    var customerId: Long? = null

    @Column(name = "wheel_id")
    @Comment("转盘id")
    var wheelId: Long? = null

    @Column
    @Comment("状态，0未发放，1.已发放")
    var status: Byte? = null

    @Column(name = "lottery_time")
    var lotteryTime: Timestamp? = null
}

@Entity
@Table(name = "ceam_lottery_times")
@EntityListeners(AuditingEntityListener::class)
class LotteryTimes {

    @Id
    @GeneratedValue
    var id: Long? = null

    @Column(name = "customer_id")
    @Comment("客户id")
    var customerId: Long? = null

    @Column
    var type: Byte? = null

    @Column(name = "friend_id")
    var friendId: Long? = null

    @Column(name = "add_time")
    var addTime: Timestamp? = null

    @Column(name = "upd_time")
    var updTime: Timestamp? = null
}

@Entity
@Table(name = "ceam_lottery_wheel")
@EntityListeners(AuditingEntityListener::class)
class LotteryWheel {

    @Id
    @GeneratedValue
    var id: Long? = null

    @Column
    var name: String? = null

    @Column
    @Comment("奖品内容")
    var content: String? = null

    @Column(name = "bg_color")
    @Comment("背景颜色")
    var bgColor: String? = null

    @Column
    @Comment("字体颜色")
    var color: String? = null

    @Column(name = "pic_url")
    @Comment("奖品图片")
    var picUrl: String? = null

    @Column(name = "activity_id")
    var activityId: Long? = null

    @Column
    var deleted: Boolean? = false

    @Column(name = "add_time")
    var addTime: Timestamp? = null

    @Column(name = "add_by")
    var addBy: Long? = null

    @Column(name = "upd_time")
    var updTime: Timestamp? = null

    @Column(name = "upd_by")
    var updBy: Long? = null
}

@Entity
@Table(name = "ceam_store")
@EntityListeners(AuditingEntityListener::class)
class Store {
    @Id
    @GeneratedValue
    var id: Long? = null

    @Column
    var name: String? = null

    @Column(length = 36)
    var phone: String? = null

    @Column
    var address: String? = null

    @Column(length = 36)
    var username: String? = null

    @Column
    var longitude: Double? = 0.0

    @Column
    var latitude: Double? = 0.0

    @Column
    var area: Double? = 0.0

    @Column
    var status: Byte? = null

    @Column
    @Comment("env_scores")
    var envScores: Double? = 0.0

    @Column
    var star: Byte? = null

    @Column
    var attrs: String? = null

    @Column(name = "pic_url")
    var picUrl: String? = null

    @Column(name = "start_time")
    var startTime: Timestamp? = null

    @Column(name = "end_time")
    var endTime: Timestamp? = null

    @Column
    @Comment("ser_scores")
    var serScores: Double? = 0.0

    @Column
    @Comment("fac_scores")
    var facScores: Double? = 0.0

    @Column
    var equipment: String? = null

    @Column
    var deleted: Boolean? = false
}

@Entity
@Table(name = "ceam_vip")
@EntityListeners(AuditingEntityListener::class)
class Vip {
    @Id
    @GeneratedValue
    var id: Long? = null

    @Column
    var amount: Double? = 0.0

    @Column
    var type: Byte? = null

    @Column
    var status: Byte? = null

    @Column
    var deleted: Boolean? = false

    @Column
    var discount: Float? = 0.0f

    @Column
    var give: Byte? = null

    @Column(length = 24)
    var name: String? = null

    @Column
    var remark: String? = null

    @Column(name = "add_time")
    var addTime: Timestamp? = null

    @Column(name = "add_by")
    var addBy: Long? = null

    @Column(name = "upd_time")
    var updTime: Timestamp? = null

    @Column(name = "upd_by")
    var updBy: Long? = null
}


@Entity
//@EqualsAndHashCode(of = ["id"])
//@ToString
//@RequiredArgsConstructor
class LineItem {
    @Id
    @GeneratedValue
    val id: Long? = null
    val description: String? = null
    val price: BigDecimal? = null
}

@Entity
class Order {
    @Id
    @GeneratedValue
    val id: Long? = null

    @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true) //
    val items: MutableList<LineItem> = ArrayList<LineItem>()

    @ManyToOne
    private val customer: Customer? = null
    fun add(item: LineItem): Order {
        items.add(item)
        return this
    }
}

@Entity
class User {
    @Id
    @GeneratedValue
    val id: Long? = null

    var username: String? = null

    @OneToOne
    @MapsId
    var info: UserInfo? = null
}

@Entity
class UserInfo {
    @Id
    @GeneratedValue
    val id: Long? = null
}

@Entity
class Trainer {
    @Id
    @GeneratedValue
    val id: Long? = null
}