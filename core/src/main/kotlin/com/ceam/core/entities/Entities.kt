package com.ceam.core.entities

import org.hibernate.annotations.Comment
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.io.Serializable
import java.sql.Date
import java.sql.Timestamp
import jakarta.persistence.*

@Entity
@Table(name = "customer_coupon")
@Comment("会员优惠表")
//@org.hibernate.annotations.Table(comment = "会员优惠表", appliesTo = "customer_coupon")
class CustomerCoupon {

    @Id
    @GeneratedValue
    var id: Long? = null

    @Column(name = "customer_id")
    var customerId: Long? = null

    @Column(name = "coupon_id")
    var couponId: Long? = null

    @Column(name = "status")
    var status: Byte? = null

    @Column(name = "used_time")
    var usedTime: Timestamp? = null

    @Column(name = "start_time")
    var startTime: Timestamp? = null

    @Column(name = "end_time")
    var endTime: Timestamp? = null

    @Column(name = "order_sn")
    var orderSn: String? = null

    @Column(name = "add_time")
    var addTime: Timestamp? = null

    @Column(name = "upd_time")
    var updTime: Timestamp? = null

    @Column(name = "deleted")
    var deleted: Boolean? = false
}

@Entity
@Table(name = "customer_info")
@Comment("会员信息表")
//@org.hibernate.annotations.Table(comment = "会员信息表", appliesTo = "customer_info")
class CustomerInfo {
    @Id
    @GeneratedValue
    var id: Long? = null
}

@Entity
@Table(name = "customer_level")
@Comment("设置用户等级表")
//@org.hibernate.annotations.Table(comment = "设置用户等级表", appliesTo = "customer_level")
class CustomerLevel {

    @Id
    @GeneratedValue
    var id: Long? = null

    @Column(name = "name", nullable = false)
    var name: String? = null

    @Column(name = "money", nullable = false)
    @Comment("购买金额")
    var money: Double? = 0.0

    @Column(name = "valid_date", nullable = false)
    @Comment("有效时间")
    var validDate = 0

    @Column(name = "is_forever", nullable = false)
    @Comment("是否为永久会员")
    var isForever = 0

    @Column(name = "is_pay", nullable = false)
    @Comment("是否购买,1购买,0不购买")
    var isPay: Boolean? = false

    @Column(name = "is_show", nullable = false)
    @Comment("是否显示 1显示,0隐藏")
    var isShow: Boolean? = false

    @Column(name = "grade", nullable = false)
    @Comment("会员等级")
    var grade: Int? = 0

    @Column(name = "discount", nullable = false)
    @Comment("享受折扣")
    var discount: Double? = 0.0

    @Column(name = "image", nullable = false)
    @Comment("会员卡背景")
    var image: String? = null

    @Column(name = "icon", nullable = false)
    @Comment("会员图标")
    var icon: String? = null

    @Column(name = "remark")
    @Comment("说明")
    var remark: String? = null

    @Column(name = "add_time", nullable = false)
    var addTime: Timestamp? = null

    @Column(name = "upd_time")
    var updTime: Timestamp? = null

    @Column(name = "deleted")
    var deleted: Boolean? = false
}

@Entity
@Table(
    name = "goods_brand",
    indexes = [
        Index(name = "pid", columnList = "pid"),
        Index(name = "is_base", columnList = "is_show"),
        Index(name = "sort", columnList = "sort"),
        Index(name = "add_time", columnList = "add_time")

    ]
)
@Comment("设置用户等级表")
//@org.hibernate.annotations.Table(comment = "品牌商表", appliesTo = "goods_brand")
class GoodsBrand {

    @Id
    @GeneratedValue
    var id: Long? = null

    @Column(name = "name", nullable = false)
    @Comment("品牌商名称")
    var name: String? = null

    @Column(name = "brands_desc", nullable = false)
    @Comment("品牌商简介")
    var brandsDesc: String? = null

    @Column(name = "pic_url")
    @Comment("品牌商页的品牌商图片")
    var picUrl: String? = null

    @Column(name = "sort_order")
    var sortOrder: Int? = 50

    @Column(name = "floor_price")
    @Comment("品牌商的商品低价，仅用于页面展示")
    var floorPrice: Double = 0.0

    @Column(name = "add_time")
    var addTime: Timestamp? = null

    @Column(name = "upde_time")
    var updeTime: Timestamp? = null

    @Column(name = "share_url")
    @Comment("分享二维码图片")
    var shareUrl: String? = null

    @Column(name = "add_by")
    @Comment("管理用户id")
    var addBy: Long? = null

    @Column(name = "deleted")
    var deleted: Boolean = false

    @Column(name = "commpany")
    var commpany: String? = null

    @Column(name = "auto_update_good")
    @Comment("自动监控更新商品")
    var autoUpdateGood: Boolean? = null

    @Column(name = "shop_url")
    @Comment("店铺url地址")
    var shopUrl: String? = null

    @Column(name = "default_cate_id")
    @Comment("默认的商品类别id")
    var defaultCateId: Long? = null

    @Column(name = "default_pages")
    @Comment("默认商品页面数")
    var defaultPages: Int? = null

    @Column(name = "add_precent")
    @Comment("店铺商品溢价")
    var addPrecent: Int? = null

    @Column(name = "address")
    @Comment("提货地址")
    var address: String? = null

    @Column(name = "longitude")
    @Comment("经度")
    var longitude: Double? = 0.0

    @Column(name = "latitude")
    @Comment("纬度")
    var latitude: Double? = 0.0

    @Column(name = "fetch_time_rules")
    @Comment("提货时间配置")
    var fetchTimeRules: String? = null
}

@Entity
@Table(
    name = "goods_category",
    indexes = [
        Index(name = "pid", columnList = "pid"),
        Index(name = "is_base", columnList = "is_show"),
        Index(name = "sort", columnList = "sort"),
        Index(name = "add_time", columnList = "add_time")

    ]
)
@Comment("商品分类表")
//@org.hibernate.annotations.Table(comment = "商品分类表", appliesTo = "goods_category")
class GoodsCategory {

    @Id
    @GeneratedValue
    var id: Long? = null

    @Column(name = "pid", unique = false)
    @Comment("父id")
    var pid: Long? = null

    @Column(name = "cate_name")
    @Comment("分类名称")
    var cateName: String? = null

    @Column(name = "sort")
    @Comment("排序")
    var sort: Int? = null

    @Column(name = "pic")
    @Comment("图标")
    var pic: String? = null

    @Column(name = "is_show")
    @Comment("是否推荐")
    var isShow: Boolean = true

    @Column(name = "add_time")
    @Comment("添加时间")
    var addTime: Timestamp? = null

    @Column(name = "upd_time")
    var updTime: Timestamp? = null

    @Column(name = "deleted")
    var deleted: Boolean = false
}

@Entity
@Table(
    name = "goods_collect",
    indexes = [
        Index(name = "user_id", columnList = "customer_id"),
        Index(name = "goods_id", columnList = "value_id")
    ]
)
@Comment("收藏表")
//@org.hibernate.annotations.Table(comment = "收藏表", appliesTo = "goods_collect")
class GoodsCollect {

    @Id
    @GeneratedValue
    var id: Long? = null

    @Column(name = "customer_id", nullable = false)
    @Comment("用户表的用户ID")
    var customerId: Long? = null

    @Column(name = "value_id", nullable = false)
    @Comment("如果type=0，则是商品ID；如果type=1，则是专题ID")
    var valueId: Int = 0

    @Column(name = "type", nullable = false)
    @Comment("收藏类型，如果type=0，则是商品ID；如果type=1，则是专题ID")
    var type: Int = 0

    @Column(name = "add_time")
    @Comment("创建时间")
    var addtime: Timestamp? = null

    @Column(name = "upd_time")
    @Comment("更新时间")
    var updtime: Timestamp? = null

    @Column(name = "deleted")
    var deleted: Boolean = false
}

@Entity
@Table(name = "goods_bargain")
@Comment("砍价表")
//@org.hibernate.annotations.Table(comment = "砍价表", appliesTo = "goods_bargain")
class GoodsBargain {

    @Id
    @GeneratedValue
    var id: Long? = null

    @Column(name = "goods_id", nullable = false)
    @Comment("关联产品ID")
    var goodsId: Long? = null

    @Column(name = "title", nullable = false)
    @Comment("砍价活动名称")
    var title: String? = null

    @Column(name = "pic_url", nullable = false)
    @Comment("砍价活动图片")
    var picUrl: String? = null

    @Column(name = "unit_name", length = 16)
    @Comment("单位名称")
    var unitName: String? = null

    @Column(name = "stock")
    @Comment("库存")
    var stock: Int? = null

    @Column(name = "sales")
    @Comment("销量")
    var sales: Int? = null

    @Column(name = "images", length = 2048, nullable = false)
    @Comment("砍价产品轮播图")
    var images: String? = null

    @Column(name = "start_time", nullable = false)
    @Comment("砍价开启时间")
    var startTime: Timestamp? = null

    @Column(name = "end_time", nullable = false)
    @Comment("砍价结束时间")
    var endTime: Timestamp? = null

    @Column(name = "store_name")
    @Comment("砍价产品名称")
    var storeName: String? = null

    @Column(name = "price")
    @Comment("砍价金额")
    var price: Double? = 0.0

    @Column(name = "min_price")
    @Comment("砍价商品最低价")
    var minPrice: Double? = 0.0

    @Column(name = "num")
    @Comment("每次购买的砍价产品数量")
    var num: Int? = null

    @Column(name = "bargain_max_price")
    @Comment("用户每次砍价的最大金额")
    var bargainMaxPrice: Double? = 0.0

    @Column(name = "bargain_min_price")
    @Comment("用户每次砍价的最小金额")
    var bargainMinPrice: Double? = 0.0

    @Column(name = "bargain_num", nullable = false)
    @Comment("用户每次砍价的次数")
    var bargainNum: Int? = 1

    @Column(name = "status", nullable = false)
    @Comment("砍价状态 0(到砍价时间不自动开启)  1(到砍价时间自动开启时间)")
    var status: Byte? = 1

    @Column(name = "description")
    @Comment("砍价详情")
    var description: String? = null

    @Column(name = "give_integral", nullable = false)
    @Comment("返多少积分")
    var giveIntegral: Double? = 0.0

    @Column(name = "info")
    @Comment("砍价活动简介")
    var info: String? = null

    @Column(name = "cost")
    @Comment("成本价")
    var cost: Double? = 0.0

    @Column(name = "sort", nullable = false)
    @Comment("排序")
    var sort: Int? = 0

    @Column(name = "deleted")
    @Comment("是否删除 0未删除 1删除")
    var deleted: Boolean? = false

    @Column(name = "add_time")
    var addTime: Timestamp? = null

    @Column(name = "upd_time")
    var updTime: Timestamp? = null

    @Column(name = "rule")
    @Comment("砍价规则")
    var rule: String? = null

    @Column(name = "look")
    @Comment("砍价产品浏览量")
    var look: Int? = 0

    @Column(name = "share")
    @Comment("砍价产品分享量")
    var share: Int? = 0
}

@Entity
@Table(name = "goods")
@Comment("商品信息表")
//@org.hibernate.annotations.Table(comment = "商品信息表", appliesTo = "goods")
class Goods {

    @Id
    @GeneratedValue
    var id: Long? = null

    @Column(name = "goods_sn", length = 36)
    @Comment("商品编号")
    var goodsSn: String? = null

    @Column(name = "name", length = 128)
    @Comment("商品名称")
    var name: String? = null

    @Column(name = "category_id")
    @Comment("分类ID")
    var categoryId: Long? = null

    @Column(name = "brand_id")
    @Comment("品牌ID")
    var brandId: Long? = null

    @Column(name = "stock")
    @Comment("库存")
    var stock: Int? = null

    @Column(name = "price")
    @Comment("价格")
    var price: String? = null

    @Column(name = "marking_price")
    @Comment("市场价")
    var markingPrice: Double = 0.0

    @Column(name = "member_price")
    @Comment("会员价")
    var memberPrice: Double = 0.0

    @Column(name = "sort_order")
    @Comment("排序")
    var sortOrder: Int? = null

    @Column(name = "is_new")
    @Comment("是否新品首发，如果设置则可以在新品首发页面展示")
    var isNew: Boolean? = null

    @Column(name = "is_hot")
    @Comment("是否人气推荐，如果设置则可以在人气推荐页面展示")
    var isHot: Boolean? = null

    @Column(name = "pic_url")
    var picUrl: String? = null

    @Column(name = "goods_type")
    @Comment("商品类型")
    var goodsType: Byte? = null

    @Column(name = "sales")
    @Comment("销量")
    var sales: Int? = null

    @Column(name = "status")
    @Comment("1上架，2下架")
    var status: Int? = null

    @Column(name = "deleted")
    var deleted: Boolean? = false

    @Column(name = "add_time")
    var addTime: Timestamp? = null
}

@Entity
@Table(name = "footprints")
@Comment("用户浏览足迹表")
//@org.hibernate.annotations.Table(comment = "用户浏览足迹表", appliesTo = "footprints")
class Footprints {

    @Id
    @GeneratedValue
    var id: Long? = null

    @Column(name = "customer_id", nullable = false)
    @Comment("用户表的用户ID")
    var customerId: Long? = null

    @Column(name = "goods_id", nullable = false)
    @Comment("浏览商品ID")
    var goodsId: Long? = null

    @Column(name = "add_time")
    var addTime: Timestamp? = null

    @Column(name = "upd_time")
    var updTime: Timestamp? = null

    @Column(name = "deleted")
    var deleted: Boolean? = false
}

@Entity
@Table(name = "coupon")
@Comment("优惠券信息及规则表")
//@org.hibernate.annotations.Table(comment = "优惠券信息及规则表", appliesTo = "coupon")
class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null

    @Column(name = "name", nullable = false, length = 63)
    @Comment("优惠券名称")
    var name: String? = null

    @Column(name = "description")
    @Comment("优惠券介绍，通常是显示优惠券使用限制文字")
    var description: String? = ""

    @Column(name = "tag", length = 63)
    @Comment("优惠券标签，例如新人专用")
    var tag: String? = ""

    @Column(name = "total", nullable = false)
    @Comment("优惠券数量，如果是0，则是无限量")
    var total: Int? = 0

    @Column(name = "discount")
    @Comment("优惠金额")
    var discount: Float? = 0.0f

    @Column(name = "min")
    @Comment("最少消费金额才能使用优惠券")
    var min: Float? = 0.0f

    @Column(name = "limit_num")
    @Comment("用户领券限制数量，如果是0，则是不限制；默认是1，限领一张")
    var limitNum: Int? = 1

    @Column(name = "type")
    @Comment("优惠券赠送类型，如果是0则通用券，用户领取；如果是1，则是注册赠券；如果是2，则是优惠券码兑换")
    var type: Byte? = 0

    @Column(name = "status")
    @Comment("优惠券状态，如果是0则是正常可用；如果是1则是过期; 如果是2则是下架")
    var status: Byte? = 0

    @Column(name = "goods_type")
    @Comment("商品限制类型，如果0则全商品，如果是1则是类目限制，如果是2则是商品限制")
    var goodsType: Byte? = 0

    @Column(name = "goods_value")
    @Comment("商品限制值，goods_type如果是0则空集合，如果是1则是类目集合，如果是2则是商品集合")
    var goodsValue: String? = ""

    @Column(name = "code", length = 63)
    @Comment("优惠券兑换码")
    var code: String? = null

    @Column(name = "time_type")
    @Comment("有效时间限制，如果是0，则基于领取时间的有效天数days；如果是1，则start_time和end_time是优惠券有效期")
    var timeType: Byte? = 0

    @Column(name = "days")
    @Comment("基于领取时间的有效天数")
    var days: Byte? = 0

    @Column(name = "start_time")
    @Comment("使用券开始时间")
    var startTime: Date? = null

    @Column(name = "end_time")
    @Comment("使用券截至时间")
    var endTime: Date? = null

    @Column(name = "add_time")
    @Comment("创建时间")
    var addtime: Timestamp? = null

    @Column(name = "upd_time")
    @Comment("更新时间")
    var updtime: Timestamp? = null

    @Column(name = "deleted")
    @Comment("逻辑删除")
    var deleted: Boolean? = false
}

@Entity
@Table(name = "commercial")
@Comment("广告表")
//@org.hibernate.annotations.Table(comment = "广告表", appliesTo = "commercial")
class Commercial {

    @Id
    @GeneratedValue
    var id: Long? = null

    @Column(name = "title", nullable = false, length = 63)
    @Comment("广告标题")
    var title: String? = null

    @Comment("所广告的商品页面或者活动页面链接地址")
    @Column(name = "link", nullable = false)
    var link: String? = null

    @Comment("广告宣传图片")
    @Column(name = "url", nullable = false)
    var url: String? = null

    @Column(name = "position")
    @Comment("广告位置：1则是首页")
    var position: Byte? = null

    @Column(name = "description")
    @Comment("活动内容")
    var description: String? = null

    @Column(name = "start_time")
    @Comment("广告开始时间")
    var startTime: Timestamp? = null

    @Column(name = "end_time")
    @Comment("广告结束时间")
    var endTime: Timestamp? = null

    @Column(name = "deleted")
    var deleted: Boolean? = false

    @Column(name = "add_time")
    var addTime: Timestamp? = null

    @Column(name = "add_by")
    var addBy: Long? = null

    @Column(name = "upd_time")
    var updTime: Timestamp? = null

    @Column(name = "upd_by")
    var updBy: Long? = null

    @Column(name = "status")
    @Comment("1启用，0禁用")
    var status: Byte? = null
}

@Entity
@Table(name = "user_role")
@Comment("用户角色表")
//@org.hibernate.annotations.Table(comment = "用户角色表", appliesTo = "user_role")
class UserRole {

    @Id
    @GeneratedValue
    var id: Long? = null

    @Column(name = "user_id", nullable = false)
    var userId: Long? = null

    @Column(name = "role_id", nullable = false)
    var roleId: Long? = null
}


/**
 * 用户表
 */
@Entity
@Table(name = "sys_user")
@Comment("用户表")
//@org.hibernate.annotations.Table(comment = "用户表", appliesTo = "sys_user")
class SysUser {

    @Id
    @GeneratedValue
    var id: Long? = null

    @Column(name = "username", nullable = false, length = 63)
    var username: String? = null

    @Column(name = "password", nullable = false)
    var password: String? = null

    @Column(name = "sex", length = 2)
    @Comment("性别：0 未知， 1男， 1 女")
    var sex: Byte? = null

    @Column(name = "birthday")
    var birthday: Date? = null

    @Column(name = "last_login_time")
    @Comment("最近一次登录时间")
    var lastLoginTime: Timestamp? = null

    @Column(name = "last_login_ip", length = 63)
    @Comment("最近一次登录IP地址")
    var lastLoginIp: String? = null

    @Column(name = "user_level")
    @Comment("用户层级 0 普通用户，1 VIP用户，2 区域代理用户")
    var userLevel: Byte? = null

    @Column(name = "nickname", length = 63)
    var nickname: String? = null

    @Column(name = "phone_num", length = 20)
    @Comment("用户手机号码")
    var phoneNum: String? = null

    @Column(name = "avatar")
    @Comment("用户头像图片")
    var avatar: String? = null

    @Column(name = "weixin_openid", length = 63)
    @Comment("微信登录openid")
    var weixinOpenId: String? = null

    @Column(name = "share_user_id")
    var shareUserId: Long? = null

    @Column(name = "status", nullable = false)
    @Comment("0 可用, 1 禁用, 2 注销")
    var status: Byte? = null

    @Column(name = "add_time")
    var addTime: Timestamp? = null

    @Column(name = "update_time")
    var updateTime: Timestamp? = null

    @Column(name = "deleted", nullable = false)
    @Comment("逻辑删除")
    var deleted: Boolean? = null

    @Column(name = "dept_id")
    var deptId: Long? = null

    @Column(name = "attention")
    var attention: Boolean? = false
}

@Entity
@Table(name = "sys_role")
@Comment("角色表")
//@org.hibernate.annotations.Table(comment = "角色表", appliesTo = "sys_role")
class SysRole {

    @Id
    @GeneratedValue
    var id: Long? = null

    @Column(name = "name", unique = true, nullable = false, length = 63)
    @Comment("角色名称")
    var name: String? = null

    @Column(name = "description")
    @Comment("角色描述")
    var description: String? = null

    @Column(name = "enabled", nullable = false)
    var enabled: Boolean? = false

    @Column(name = "data_scope")
    @Comment("数据权限")
    var dataScope: String? = null

    @Column(name = "permission")
    @Comment("功能权限")
    var permission: String? = null

    @Column(name = "level")
    @Comment("角色级别")
    var level: Byte? = null

    @Column(name = "deleted")
    @Comment("逻辑删除")
    var deleted: Boolean? = false

    @Column(name = "add_by")
    var addBy: Long? = null

    @Column(name = "update_time")
    var updateTime: Timestamp? = null

    @Column(name = "add_time")
    var addTime: Timestamp? = null
}

@Entity
@Table(
    name = "sys_menu",
    indexes = [
        Index(name = "index_pid", columnList = "pid")
    ]
)
@Comment("系统菜单表")
//@org.hibernate.annotations.Table(comment = "系统菜单表", appliesTo = "sys_menu")
class SysMenu {

    @Id
    @GeneratedValue
    var id: Long? = null

    @Column(name = "i_frame")
    @Comment("是否外链")
    var iframe: Boolean? = false

    @Column(name = "name")
    var name: String? = null

    @Column(name = "component")
    @Comment("组件")
    var component: String? = null

    @Column(name = "pid", nullable = false)
    @Comment("上级菜单ID")
    var pid: Long? = null

    @Column(name = "sort", nullable = false)
    @Comment("排序")
    var sort: Long? = null

    @Column(name = "icon")
    @Comment("图标")
    var icon: String? = null

    @Column(name = "path")
    @Comment("链接地址")
    var path: String? = null

    @Column(name = "缓存")
    @Comment("链接地址")
    var cache: Boolean = false

    @Column(name = "hidden")
    @Comment("是否隐藏")
    var hidden: Boolean = false

    @Column(name = "component_name", length = 20)
    @Comment("组件名称")
    var componentName: String? = null

    @Column(name = "add_time")
    @Comment("创建日期")
    var addTime: Timestamp? = null

    @Column(name = "permission")
    @Comment("权限")
    var permission: String? = null

    @Column(name = "type", length = 11)
    @Comment("类型")
    var type: Int? = null

    @Column(name = "upd_time")
    var updTime: Timestamp? = null

    @Column(name = "deleted")
    var deleted: Boolean? = false
}

@Entity
@Table(name = "sys_job")
@Comment("岗位")
//@org.hibernate.annotations.Table(comment = "岗位", appliesTo = "sys_job")
class SysJob {

    @Id
    @GeneratedValue
    var id: Long? = null

    @Column(name = "name")
    @Comment("岗位名称")
    var name: String? = null

    /**
     * 岗位状态
     */
    @Column(name = "enabled")
    @Comment("岗位状态")
    var enabled: Boolean? = true

    @Column(name = "dept_id")
    @Comment("部门ID")
    var deptId: Long? = null

    @Column(name = "add_time")
    @Comment("创建日期")
    var addTime: Timestamp? = null


    @Column(name = "upd_time")
    var updTime: Timestamp? = null

    @Column(name = "deleted")
    var deleted: Boolean? = false
}


@Entity
@Table(name = "sys_dict_detail")
@Comment("数据字典详情")
//@org.hibernate.annotations.Table(comment = "数据字典详情", appliesTo = "sys_dict_detail")
class SysDictDetail {

    @Id
    @GeneratedValue
    var id: Long? = null

    @Column(name = "label", nullable = false)
    @Comment("字典标签")
    var label: String? = null

    @Column(name = "value", nullable = false)
    @Comment("字典值")
    var value: String? = null

    @Column(name = "sort")
    @Comment("排序")
    var sort: String? = null

    @Column(name = "dict_id")
    @Comment("字典id")
    var dictId: Long? = null

    @Column(name = "add_time")
    @Comment("创建日期")
    var addTime: Timestamp? = null

    @Column(name = "upd_time")
    var updTime: Timestamp? = null

    @Column(name = "deleted")
    var deleted: Boolean? = false
}

@Entity
@Table(name = "sys_dict")
@Comment("数据字典")
//@org.hibernate.annotations.Table(comment = "数据字典", appliesTo = "sys_dict")
class SysDict {

    @Id
    @GeneratedValue
    var id: Long? = null

    @Column(name = "name", nullable = false)
    @Comment("字典名称")
    var name: String? = null

    @Column(name = "remark")
    @Comment("描述")
    var remark: String? = null

    @Column(name = "add_time")
    @Comment("创建日期")
    var addTime: Timestamp? = null

    @Column(name = "upd_time")
    var updtime: Timestamp? = null

    @Column(name = "deleted")
    var deleted: Boolean? = null

}

@Entity
@Table(name = "sys_dept")
@Comment("部门")
//@org.hibernate.annotations.Table(comment = "部门", appliesTo = "sys_dept")
class SysDept {

    @Id
    @GeneratedValue
    var id: Long? = null

    @Column(name = "name")
    var name: String? = null

    @Column(name = "pid")
    @Comment("上级部门")
    var pid: Long? = null

    @Column(name = "enabled", nullable = false)
    @Comment("状态")
    var enabled: Boolean? = true

    @Column(name = "add_time")
    @Comment("创建日期")
    var addTime: Timestamp? = null

    @Column(name = "upd_time")
    var updTime: Timestamp? = null

    @Column(name = "deleted")
    var deleted: Boolean? = false
}

@Entity
@Table(name = "role_menu")
@Comment("角色菜单")
//@org.hibernate.annotations.Table(comment = "角色菜单", appliesTo = "role_menu")
class RoleMenu {

    @Id
    @GeneratedValue
    var id: Long? = null

    @Column(name = "role_id", nullable = false)
    var roleId: Long? = null

    @Column(name = "menu_id")
    @Comment("菜单ID-只对应根菜单")
    var menuId: Long? = null
}

@Entity
@Table(
    name = "goods_seckill", indexes = [
        Index(name = "product_id", columnList = "goods_id"),
        Index(name = "start_time", columnList = "start_time, end_time"),
        Index(name = "is_del", columnList = "deleted"),
        Index(name = "is_show", columnList = "status"),
        Index(name = "add_time", columnList = "add_time"),
        Index(name = "sort", columnList = "sort"),
    ]
)
@Comment("商品秒杀产品表")
//@org.hibernate.annotations.Table(comment = "商品秒杀产品表", appliesTo = "goods_seckill")
class GoodsSeckill {

    @Id
    @GeneratedValue
    var id: Long? = null

    @Column(name = "goods_id", nullable = false)
    @Comment("商品id")
    var goodsId: Long? = null

    @Column(name = "pic_url", nullable = false)
    @Comment("推荐图")
    var picUrl: String? = null

    @Column(name = "images", length = 2048, nullable = false)
    @Comment("轮播图")
    var images: String? = null

    @Column(name = "title", nullable = false)
    @Comment("活动标题")
    var title: String? = null

    @Column(name = "info", nullable = false)
    @Comment("简介")
    var info: String? = null

    @Column(name = "price")
    @Comment("价格")
    var price: Double? = 0.0

    @Column(name = "cost")
    @Comment("成本")
    var cost: Double? = 0.0

    @Column(name = "origin_price")
    @Comment("原价")
    var originPrice: Double? = 0.0

    @Column(name = "give_integral")
    @Comment("返多少积分")
    var giveIntegral: Double? = 0.0

    @Column(name = "sort", nullable = false)
    @Comment("排序")
    var sort: Int? = null

    @Column(name = "stock", nullable = false)
    @Comment("库存")
    var stock: Int? = null

    @Column(name = "sales", nullable = false)
    @Comment("销量")
    var sales: Int? = 0

    @Column(name = "unit_name", nullable = false)
    @Comment("单位名")
    var unitName: String? = null

    @Column(name = "description")
    var description: String? = null

    @Column(name = "start_time", nullable = false)
    @Comment("开始时间")
    var startTime: Date? = null

    @Column(name = "end_time", nullable = false)
    @Comment("结束时间")
    var endTime: Date? = null

    @Column(name = "add_time", nullable = false)
    @Comment("添加时间")
    var addTime: Timestamp? = null

    @Column(name = "upd_time")
    var updTime: Timestamp? = null

    @Column(name = "status", nullable = false)
    @Comment("产品状态")
    var status: Byte? = null

    @Column(name = "deleted", nullable = false)
    var deleted: Boolean = false

    @Column(name = "max_num")
    @Comment("最多秒杀几个")
    var maxNum: Int? = null

    @Column(name = "is_show")
    @Comment("显示")
    var isShow: Boolean = true

    @Column(name = "time_id")
    @Comment("时间段id")
    var timeId: Int = 0

    @Column(name = "spec_type")
    @Comment("规格 0单 1多")
    var specType: Byte? = null

    @Column(name = "temp_id")
    @Comment("运费模板id")
    var tempId: Int? = null
}