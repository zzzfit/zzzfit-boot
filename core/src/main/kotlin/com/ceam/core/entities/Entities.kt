package com.ceam.core.entities

import java.sql.Date
import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name = "customer_coupon")
class CustomerCoupon {
    /**
     * null
     */
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null

    /**
     * null
     */
    @Column(name = "customer_id")
    var customerid: Long? = null

    /**
     * null
     */
    @Column(name = "coupon_id")
    var couponid: Long? = null

    /**
     * null
     */
    @Column(name = "status")
    var status: Int? = null

    /**
     * null
     */
    @Column(name = "used_time")
    var usedtime: Timestamp? = null

    /**
     * null
     */
    @Column(name = "start_time")
    var starttime: Timestamp? = null

    /**
     * null
     */
    @Column(name = "end_time")
    var endtime: Timestamp? = null

    /**
     * null
     */
    @Column(name = "order_sn")
    var ordersn: String? = null

    /**
     * null
     */
    @Column(name = "add_time")
    var addtime: Timestamp? = null

    /**
     * null
     */
    @Column(name = "upd_time")
    var updtime: Timestamp? = null

    /**
     * null
     */
    @Column(name = "deleted")
    var deleted: Int? = null

}

/**
 * 会员信息表
 */
@Entity
@Table(name = "customer_info")
class CustomerInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    open var id: Long? = null
}


/**
 * 设置用户等级表
 */
@Entity
@Table(name = "customer_level")
class CustomerLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null

    /**
     * 会员名称
     */
    @Column(name = "name")
    var name = ""
    //FIXME not support type getMoney() {
    //FIXME not support type money) {
    /**
     * 购买金额
     */
    @Column(name = "money")
    var money // medecimal(10,2)//FIXME not support type money;
            = 0.0

    /**
     * 有效时间
     */
    @Column(name = "valid_date")
    var validdate = 0

    /**
     * 是否为永久会员
     */
    @Column(name = "is_forever")
    var isforever = 0

    /**
     * 是否购买,1购买,0不购买
     */
    @Column(name = "is_pay")
    var ispay = 0

    /**
     * 是否显示 1显示,0隐藏
     */
    @Column(name = "is_show")
    var isshow = 0

    /**
     * 会员等级
     */
    @Column(name = "grade")
    var grade = 0
    // decimal(10,2)//FIXME not support type getDiscount() {
    // decimal(10,2)//FIXME not support type discount) {
    /**
     * 享受折扣
     */
    @Column(name = "discount")
    var discount //decimal(10,2)//FIXME not support type discount;
            = 0.0

    /**
     * 会员卡背景
     */
    @Column(name = "image")
    var image = ""

    /**
     * 会员图标
     */
    @Column(name = "icon")
    var icon = ""

    /**
     * 说明
     */
    @Column(name = "remark")
    var remark: String? = null

    /**
     * 添加时间
     */
    @Column(name = "add_time")
    var addtime: Timestamp? = null

    /**
     * null
     */
    @Column(name = "upd_time")
    var updtime: Timestamp? = null

    /**
     * null
     */
    @Column(name = "deleted")
    var deleted: Int? = null

}

/**
 * 品牌商表
 */
@Entity
@Table(name = "goods_brand")
class GoodsBrand {
    /**
     * null
     */
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null

    /**
     * 品牌商名称
     */
    @Column(name = "name")
    var name = ""

    /**
     * 品牌商简介
     */
    @Column(name = "brands_desc")
    var brandsdesc = ""

    /**
     * 品牌商页的品牌商图片
     */
    @Column(name = "pic_url")
    var picurl = ""

    /**
     * null
     */
    @Column(name = "sort_order")
    var sortorder: Int? = null
    //decimal(10,2)//FIXME not support type getFloorprice() {
    //decimal(10,2)//FIXME not support type floorprice) {
    /**
     * 品牌商的商品低价，仅用于页面展示
     */
    @Column(name = "floor_price")
    var floorPrice // decimal(10,2)//FIXME not support type floorPrice;
            = 0.0

    /**
     * 创建时间
     */
    @Column(name = "add_time")
    var addtime: Timestamp? = null

    /**
     * 更新时间
     */
    @Column(name = "upde_time")
    var updetime: Timestamp? = null

    /**
     * 分享二维码图片
     */
    @Column(name = "share_url")
    var shareurl: String? = null

    /**
     * 管理用户id
     */
    @Column(name = "add_by")
    var addby: Long? = null

    /**
     * 逻辑删除
     */
    @Column(name = "deleted")
    var deleted = 0

    /**
     * null
     */
    @Column(name = "commpany")
    var commpany: String? = null

    /**
     * 自动监控更新商品
     */
    @Column(name = "auto_update_good")
    var autoupdategood: Int? = null

    /**
     * 店铺url地址
     */
    @Column(name = "shop_url")
    var shopurl: String? = null

    /**
     * 默认的商品类别id
     */
    @Column(name = "default_cate_id")
    var defaultcateid: Long? = null

    /**
     * 默认商品页面数
     */
    @Column(name = "default_pages")
    var defaultpages: Int? = null

    /**
     * 店铺商品溢价
     */
    @Column(name = "add_precent")
    var addprecent: Int? = null

    /**
     * 提货地址
     */
    @Column(name = "address")
    var address: String? = null
    //}  decimal(10,7)//FIXME not support type getLongitude() {
    //decimal(10,7)//FIXME not support type longitude) {
    /**
     * 经度
     */
    @Column(name = "longitude")
    var longitude // decimal(10,7)//FIXME not support type longitude;
            = 0.0

    //decimal(10,7)//FIXME not support type getLatitude() {
    //decimal(10,7)//FIXME not support type latitude) {
    /**
     * 纬度
     */
    @Column(name = "latitude")
    var latitude // decimal(10,7)//FIXME not support type latitude;
            = 0.0

    /**
     * 提货时间配置
     */
    @Column(name = "fetch_time_rules")
    var fetchtimerules: String? = null

}


/**
 * 商品分类表
 */
@Entity
@Table(name = "goods_category")
class GoodsCategory {
    /**
     * 商品分类表ID
     */
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null

    /**
     * 父id
     */
    @Column(name = "pid")
    var pid: Long? = null

    /**
     * 分类名称
     */
    @Column(name = "cate_name")
    var catename: String? = null

    /**
     * 排序
     */
    @Column(name = "sort")
    var sort: Int? = null

    /**
     * 图标
     */
    @Column(name = "pic")
    var pic = ""

    /**
     * 是否推荐
     */
    @Column(name = "is_show")
    var isshow = 1

    /**
     * 添加时间
     */
    @Column(name = "add_time")
    var addtime: Timestamp? = null

    /**
     * null
     */
    @Column(name = "upd_time")
    var updtime: Timestamp? = null

    /**
     * 删除状态
     */
    @Column(name = "deleted")
    var deleted = 0

}


/**
 * 收藏表
 */
@Entity
@Table(name = "goods_collect")
class GoodsCollect {
    /**
     * null
     */
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null

    /**
     * 用户表的用户ID
     */
    @Column(name = "customer_id")
    var customerid = 0L

    /**
     * 如果type=0，则是商品ID；如果type=1，则是专题ID
     */
    @Column(name = "value_id")
    var valueid = 0

    /**
     * 收藏类型，如果type=0，则是商品ID；如果type=1，则是专题ID
     */
    @Column(name = "type")
    var type = 0

    /**
     * 创建时间
     */
    @Column(name = "add_time")
    var addtime: Timestamp? = null

    /**
     * 更新时间
     */
    @Column(name = "upd_time")
    var updtime: Timestamp? = null

    /**
     * 逻辑删除
     */
    @Column(name = "deleted")
    var deleted = 0

}

/**
 * 砍价表
 */
@Entity
@Table(name = "goods_bargain")
class GoodsBargain {
    /**
     * 砍价产品ID
     */
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null

    /**
     * 关联产品ID
     */
    @Column(name = "goods_id")
    var goodsid: Long? = null

    /**
     * 砍价活动名称
     */
    @Column(name = "title")
    var title: String? = null

    /**
     * 砍价活动图片
     */
    @Column(name = "pic_url")
    var picurl: String? = null

    /**
     * 单位名称
     */
    @Column(name = "unit_name")
    var unitname: String? = null

    /**
     * 库存
     */
    @Column(name = "stock")
    var stock: Int? = null

    /**
     * 销量
     */
    @Column(name = "sales")
    var sales: Int? = null

    /**
     * 砍价产品轮播图
     */
    @Column(name = "images")
    var images: String? = null

    /**
     * 砍价开启时间
     */
    @Column(name = "start_time")
    var starttime: Timestamp? = null

    /**
     * 砍价结束时间
     */
    @Column(name = "end_time")
    var endtime: Timestamp? = null

    /**
     * 砍价产品名称
     */
    @Column(name = "store_name")
    var storename: String? = null
    //decimal(8,2)//FIXME not support type getPrice() {
    //(8,2)//FIXME not support type price) {
    /**
     * 砍价金额
     */
    @Column(name = "price")
    var price //decimal(8,2)//FIXME not support type price;
            = 0.0

    //decimal(8,2)//FIXME not support type getMinprice() {
    //decimal(8,2)//FIXME not support type minprice) {
    /**
     * 砍价商品最低价
     */
    @Column(name = "min_price")
    var minPrice //decimal(8,2)//FIXME not support type minPrice;
            = 0.0

    /**
     * 每次购买的砍价产品数量
     */
    @Column(name = "num")
    var num: Int? = null
    //decimal(8,2)//FIXME not support type getBargainmaxprice() {
    // decimal(8,2)//FIXME not support type bargainmaxprice) {
    /**
     * 用户每次砍价的最大金额
     */
    @Column(name = "bargain_max_price")
    var bargainMaxPrice //decimal(8,2)//FIXME not support type bargainMaxPrice;
            = 0.0

    //} decimal(8,2)//FIXME not support type getBargainminprice() {
    // decimal(8,2)//FIXME not support type bargainminprice) {
    /**
     * 用户每次砍价的最小金额
     */
    @Column(name = "bargain_min_price")
    var bargainminprice //decimal(8,2)//FIXME not support type bargainMinPrice;
            = 0.0

    /**
     * 用户每次砍价的次数
     */
    @Column(name = "bargain_num")
    var bargainnum = 1

    /**
     * 砍价状态 0(到砍价时间不自动开启)  1(到砍价时间自动开启时间)
     */
    @Column(name = "status")
    var status = 1

    /**
     * 砍价详情
     */
    @Column(name = "description")
    var description: String? = null

    //decimal(10,2)//FIXME not support type getGiveintegral() {
    //decimal(10,2)//FIXME not support type giveintegral) {
    /**
     * 反多少积分
     */
    @Column(name = "give_integral")
    var giveintegral //decimal(10,2)//FIXME not support type giveIntegral;
            = 0.0

    /**
     * 砍价活动简介
     */
    @Column(name = "info")
    var info: String? = null
    //  decimal(8,2)//FIXME not support type getCost() {
    //decimal(8,2)//FIXME not support type cost) {
    /**
     * 成本价
     */
    @Column(name = "cost")
    var cost //decimal(8,2)//FIXME not support type cost;
            = 0.0

    /**
     * 排序
     */
    @Column(name = "sort")
    var sort = 0

    /**
     * 是否删除 0未删除 1删除
     */
    @Column(name = "deleted")
    var deleted = 0

    /**
     * 添加时间
     */
    @Column(name = "add_time")
    var addtime: Timestamp? = null

    /**
     * null
     */
    @Column(name = "upd_time")
    var updtime: Timestamp? = null

    /**
     * 砍价规则
     */
    @Column(name = "rule")
    var rule: String? = null

    /**
     * 砍价产品浏览量
     */
    @Column(name = "look")
    var look = 0

    /**
     * 砍价产品分享量
     */
    @Column(name = "share")
    var share = 0

}

/**
 * 商品信息表
 */
@Entity
@Table(name = "goods")
class Goods {
    /**
     * null
     */
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null

    /**
     * 商品编号
     */
    @Column(name = "goods_sn")
    var goodssn: String? = null

    /**
     * 商品名称
     */
    @Column(name = "name")
    var name: String? = null

    /**
     * 分类ID
     */
    @Column(name = "category_id")
    var categoryid: Long? = null

    /**
     * 品牌ID
     */
    @Column(name = "brand_id")
    var brandid: Long? = null

    /**
     * 库存
     */
    @Column(name = "stock")
    var stock: Int? = null

    /**
     * 价格
     */
    @Column(name = "price")
    var price: String? = null
    //) decimal(12,2)//FIXME not support type getMarkingprice() {
    /**
     * 市场价
     */
    @Column(name = "marking_price")
    var markingPrice // decimal(12,2)//FIXME not support type markingPrice;
            = 0.0
        private set

    /**
     * 会员价
     */
    @Column(name = "member_price")
    private var memberPrice //decimal(12,2)//FIXME not support type memberPrice;
            = 0.0

    /**
     * 排序
     */
    @Column(name = "sort_order")
    var sortorder: Int? = null

    /**
     * 是否新品首发，如果设置则可以在新品首发页面展示
     */
    @Column(name = "is_new")
    var isnew: Int? = null

    /**
     * 是否人气推荐，如果设置则可以在人气推荐页面展示
     */
    @Column(name = "is_hot")
    var ishot: Int? = null

    /**
     * null
     */
    @Column(name = "pic_url")
    var picurl: String? = null

    /**
     * 商品类型
     */
    @Column(name = "goods_type")
    var goodstype: Int? = null

    /**
     * 销量
     */
    @Column(name = "sales")
    var sales: Int? = null

    /**
     * 1上架，2下架
     */
    @Column(name = "status")
    var status: Int? = null

    /**
     * null
     */
    @Column(name = "deleted")
    var deleted: Int? = null

    /**
     * null
     */
    @Column(name = "add_time")
    var addtime: Timestamp? = null

    fun setMarkingprice(markingPrice: Double) { // decimal(12,2)//FIXME not support type markingprice) {
        this.markingPrice = markingPrice
    }

    fun getmemberPrice(): Double { //decimal(12,2)//FIXME not support type getMemberprice() {
        return memberPrice
    }

    fun setmemberPrice(memberPrice: Double) { //decimal(12,2)//FIXME not support type memberprice) {
        this.memberPrice = memberPrice
    }

}

/**
 * 用户浏览足迹表
 */
@Entity
@Table(name = "footprints")
class Footprints {
    /**
     * null
     */
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null

    /**
     * 用户表的用户ID
     */
    @Column(name = "customer_id")
    var customerid = 0L

    /**
     * 浏览商品ID
     */
    @Column(name = "goods_id")
    var goodsid = 0L

    /**
     * 创建时间
     */
    @Column(name = "add_time")
    var addtime: Timestamp? = null

    /**
     * 更新时间
     */
    @Column(name = "upd_time")
    var updtime: Timestamp? = null

    /**
     * 逻辑删除
     */
    @Column(name = "deleted")
    var deleted = 0

}

/**
 * 优惠券信息及规则表
 */
@Entity
@Table(name = "coupon")
class Coupon {
    /**
     * null
     */
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null

    /**
     * 优惠券名称
     */
    @Column(name = "name")
    var name: String? = null

    /**
     * 优惠券介绍，通常是显示优惠券使用限制文字
     */
    @Column(name = "description")
    var description = ""

    /**
     * 优惠券标签，例如新人专用
     */
    @Column(name = "tag")
    var tag = ""

    /**
     * 优惠券数量，如果是0，则是无限量
     */
    @Column(name = "total")
    var total = 0
    //decimal(10,2)//FIXME not support type getDiscount() {
    // decimal(10,2)//FIXME not support type discount) {
    /**
     * 优惠金额，
     */
    @Column(name = "discount")
    var discount // decimal(10,2)//FIXME not support type discount;
            = 0.0

    //decimal(10,2)//FIXME not support type getMin() {
    //decimal(10,2)//FIXME not support type min) {
    /**
     * 最少消费金额才能使用优惠券。
     */
    @Column(name = "min")
    var min //decimal(10,2)//FIXME not support type min;
            = 0.0

    /**
     * 用户领券限制数量，如果是0，则是不限制；默认是1，限领一张.
     */
    @Column(name = "limit_num")
    var limitnum = 1

    /**
     * 优惠券赠送类型，如果是0则通用券，用户领取；如果是1，则是注册赠券；如果是2，则是优惠券码兑换；
     */
    @Column(name = "type")
    var type = 0

    /**
     * 优惠券状态，如果是0则是正常可用；如果是1则是过期; 如果是2则是下架。
     */
    @Column(name = "status")
    var status = 0

    /**
     * 商品限制类型，如果0则全商品，如果是1则是类目限制，如果是2则是商品限制。
     */
    @Column(name = "goods_type")
    var goodstype = 0

    /**
     * 商品限制值，goods_type如果是0则空集合，如果是1则是类目集合，如果是2则是商品集合。
     */
    @Column(name = "goods_value")
    var goodsvalue: String = ""

    /**
     * 优惠券兑换码
     */
    @Column(name = "code")
    var code: String? = null

    /**
     * 有效时间限制，如果是0，则基于领取时间的有效天数days；如果是1，则start_time和end_time是优惠券有效期；
     */
    @Column(name = "time_type")
    var timetype = 0

    /**
     * 基于领取时间的有效天数days。
     */
    @Column(name = "days")
    var days = 0

    /**
     * 使用券开始时间
     */
    @Column(name = "start_time")
    var starttime: Date? = null

    /**
     * 使用券截至时间
     */
    @Column(name = "end_time")
    var endtime: Date? = null

    /**
     * 创建时间
     */
    @Column(name = "add_time")
    var addtime: Timestamp? = null

    /**
     * 更新时间
     */
    @Column(name = "upd_time")
    var updtime: Timestamp? = null

    /**
     * 逻辑删除
     */
    @Column(name = "deleted")
    var deleted = 0

}

/**
 * 广告表
 */
@Entity
@Table(name = "commercial")
class Commercial {

    @Id
    @GeneratedValue
    var id: Long? = null

    /**
     * 广告标题
     */
    @Column(name = "title", nullable = false, length = 64)
    var title: String? = null

    /**
     * 所广告的商品页面或者活动页面链接地址
     */
    @Column(name = "link", nullable = false)
    var link: String? = null

    /**
     * 广告宣传图片
     */
    @Column(name = "url", nullable = false)
    var url: String? = null

    /**
     * 广告位置：1则是首页
     */
    @Column(name = "position", length = 2)
    var position: Int? = null

    /**
     * 活动内容
     */
    @Column(name = "description")
    var description: String? = null

    /**
     * 广告开始时间
     */
    @Column(name = "start_time")
    var startTime: Timestamp? = null

    /**
     * 广告结束时间
     */
    @Column(name = "end_time")
    var endTime: Timestamp? = null

    /**
     * null
     */
    @Column(name = "deleted")
    var deleted: Int? = null

    /**
     * null
     */
    @Column(name = "add_time")
    var addTime: Timestamp? = null

    /**
     * null
     */
    @Column(name = "add_by")
    var addBy: Long? = null

    /**
     * null
     */
    @Column(name = "upd_time")
    var updTime: Timestamp? = null

    /**
     * null
     */
    @Column(name = "upd_by")
    var updBy: Long? = null

    /**
     * 1启用，0禁用
     */
    @Column(name = "status", length = 2)
    var status: Int? = null
}


/**
 * 用户角色表
 */
@Entity
@Table(name = "user_role")
class UserRole {

    @Id
    @GeneratedValue
    var id: Long? = null

    /**
     * null
     */
    @Column(name = "user_id", nullable = false)
    var userId: Long? = null

    /**
     * null
     */
    @Column(name = "role_id", nullable = false)
    var roleId: Long? = null
}


/**
 * 用户表
 */
@Entity
@Table(name = "sys_user")
class SysUser {

    @Id
    @GeneratedValue
    var id: Long? = null

    /**
     * 用户名称
     */
    @Column(name = "username", nullable = false, length = 63)
    var username: String? = null

    /**
     * 用户密码
     */
    @Column(name = "password", nullable = false, length = 63)
    var password: String? = null

    /**
     * 性别：0 未知， 1男， 1 女
     */
    @Column(name = "sex", length = 2)
    var sex: Int? = null

    /**
     * 生日
     */
    @Column(name = "birthday")
    var birthday: Date? = null

    /**
     * 最近一次登录时间
     */
    @Column(name = "last_login_time")
    var lastLoginTime: Timestamp? = null

    /**
     * 最近一次登录IP地址
     */
    @Column(name = "last_login_ip", length = 63)
    var lastLoginIp: String? = null

    /**
     * 用户层级 0 普通用户，1 VIP用户，2 区域代理用户
     */
    @Column(name = "user_level", length = 2)
    var userLevel: Int? = null

    /**
     * 用户昵称或网络名称
     */
    @Column(name = "nickname", length = 63)
    var nickname: String? = null

    /**
     * 用户手机号码
     */
    @Column(name = "phone_num", length = 20)
    var phoneNum: String? = null

    /**
     * 用户头像图片
     */
    @Column(name = "avatar")
    var avatar: String? = null

    /**
     * 微信登录openid
     */
    @Column(name = "weixin_openid", length = 63)
    var weixinOpenId: String? = null

    /**
     * null
     */
    @Column(name = "share_user_id")
    var shareUserId: Long? = null

    /**
     * 0 可用, 1 禁用, 2 注销
     */
    @Column(name = "status", nullable = false, length = 2)
    var status: Int? = null

    /**
     * null
     */
    @Column(name = "add_time")
    var addTime: Timestamp? = null

    /**
     * null
     */
    @Column(name = "update_time")
    var updateTime: Timestamp? = null

    /**
     * 逻辑删除
     */
    @Column(name = "deleted", nullable = false)
    var deleted: Boolean? = null

    /**
     * null
     */
    @Column(name = "dept_id")
    var deptId: Long? = null

    /**
     * null
     */
    @Column(name = "attention")
    var attention: Boolean? = false
}


/**
 * 角色表
 */
@Entity
@Table(name = "sys_role")
class SysRole {

    @Id
    @GeneratedValue
    var id: Long? = null

    /**
     * 角色名称
     */
    @Column(name = "name", unique = true, nullable = false, length = 63)
    var name: String? = null

    /**
     * 角色描述
     */
    @Column(name = "description")
    var description: String? = null

    /**
     * 是否启用
     */
    @Column(name = "enabled", nullable = false)
    var enabled: Boolean? = null

    /**
     * 数据权限
     */
    @Column(name = "data_scope")
    var dataScope: String? = null

    /**
     * 功能权限
     */
    @Column(name = "permission")
    var permission: String? = null

    /**
     * 角色级别
     */
    @Column(name = "level", length = 2)
    var level: Int? = null

    /**
     * 逻辑删除
     */
    @Column(name = "deleted")
    var deleted: Boolean? = null

    @Column(name = "add_by")
    var addBy: Long? = null

    @Column(name = "update_time")
    var updateTime: Timestamp? = null

    @Column(name = "add_time")
    var addTime: Timestamp? = null
}


/**
 * 系统菜单表
 */
@Entity
@Table(name = "sys_menu")
class SysMenu {

    @Id
    @GeneratedValue
    var id: Long? = null

    //} bit(1)//FIXME not support type getIframe() {
    //  (1)//FIXME not support type iframe) {
    /**
     * 是否外链
     */
    @Column(name = "i_frame")
    var iframe // bit(1)//FIXME not support type iFrame;
            = false

    /**
     * 菜单名称
     */
    @Column(name = "name")
    var name: String? = null

    /**
     * 组件
     */
    @Column(name = "component")
    var component: String? = null

    /**
     * 上级菜单ID
     */
    @Column(name = "pid")
    var pid: Long? = null

    /**
     * 排序
     */
    @Column(name = "sort")
    var sort: Long? = null

    /**
     * 图标
     */
    @Column(name = "icon")
    var icon: String? = null

    /**
     * 链接地址
     */
    @Column(name = "path")
    var path: String? = null
    //bit(1)//FIXME not support type getCache() {
    //bit(1)//FIXME not support type cache) {
    /**
     * 缓存
     */
    @Column(name = "cache")
    var cache: Boolean // bit(1)//FIXME not support type cache;
            = false

    //(1)//FIXME not support type getHidden() {
    //(1)//FIXME not support type hidden) {
    /**
     * 是否隐藏
     */
    @Column(name = "hidden")
    var hidden: Boolean //bit(1)//FIXME not support type hidden;
            = false

    /**
     * 组件名称
     */
    @Column(name = "component_name", length = 20)
    var componentName: String? = null

    /**
     * 创建日期
     */
    @Column(name = "add_time")
    var addTime: Timestamp? = null

    /**
     * 权限
     */
    @Column(name = "permission")
    var permission: String? = null

    /**
     * 类型
     */
    @Column(name = "type", length = 11)
    var type: Int? = null

    /**
     * null
     */
    @Column(name = "upd_time")
    var updTime: Timestamp? = null

    /**
     * null
     */
    @Column(name = "deleted")
    var deleted: Boolean? = null
}


/**
 * 岗位
 */
@Entity
@Table(name = "sys_job")
class SysJob {

    @Id
    @GeneratedValue
    var id: Long? = null

    /**
     * 岗位名称
     */
    @Column(name = "name")
    var name: String? = null

    /**
     * 岗位状态
     */
    @Column(name = "enabled")
    var enabled: Int? = null

    /**
     * 部门ID
     */
    @Column(name = "dept_id")
    var deptid: Long? = null

    /**
     * 创建日期
     */
    @Column(name = "add_time")
    var addtime: Timestamp? = null

    /**
     * null
     */
    @Column(name = "upd_time")
    var updtime: Timestamp? = null

    /**
     * null
     */
    @Column(name = "deleted")
    var deleted: Int? = null

}


/**
 * 数据字典详情
 */
@Entity
@Table(name = "sys_dict_detail")
class SysDictDetail {
    /**
     * null
     */
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null

    /**
     * 字典标签
     */
    @Column(name = "label")
    var label: String? = null

    /**
     * 字典值
     */
    @Column(name = "value")
    var value: String? = null

    /**
     * 排序
     */
    @Column(name = "sort")
    var sort: String? = null

    /**
     * 字典id
     */
    @Column(name = "dict_id")
    var dictid: Long? = null

    /**
     * 创建日期
     */
    @Column(name = "add_time")
    var addtime: Timestamp? = null

    /**
     * null
     */
    @Column(name = "upd_time")
    var updtime: Timestamp? = null

    /**
     * null
     */
    @Column(name = "deleted")
    var deleted: Int? = null

}


/**
 * 数据字典
 */
@Entity
@Table(name = "sys_dict")
class SysDict {
    /**
     * null
     */
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null

    /**
     * 字典名称
     */
    @Column(name = "name")
    var name: String? = null

    /**
     * 描述
     */
    @Column(name = "remark")
    var remark: String? = null

    /**
     * 创建日期
     */
    @Column(name = "add_time")
    var addtime: Timestamp? = null

    /**
     * null
     */
    @Column(name = "upd_time")
    var updtime: Timestamp? = null

    /**
     * null
     */
    @Column(name = "deleted")
    var deleted: Int? = null

}


/**
 * 部门
 */
@Entity
@Table(name = "sys_dept")
class SysDept {
    /**
     * ID
     */
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null

    /**
     * 名称
     */
    @Column(name = "name")
    var name: String? = null

    /**
     * 上级部门
     */
    @Column(name = "pid")
    var pid: Long? = null

    /**
     * 状态
     */
    @Column(name = "enabled")
    var enabled: Int? = null

    /**
     * 创建日期
     */
    @Column(name = "add_time")
    var addtime: Timestamp? = null

    /**
     * null
     */
    @Column(name = "upd_time")
    var updtime: Timestamp? = null

    /**
     * null
     */
    @Column(name = "deleted")
    var deleted: Int? = null

}


/**
 * 角色菜单
 */
@Entity
@Table(name = "role_menu")
class RoleMenu {
    /**
     * 角色映射对应菜单的标识id
     */
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null

    /**
     * 角色ID
     */
    @Column(name = "role_id")
    var roleid: Long? = null

    /**
     * 菜单ID-只对应根菜单
     */
    @Column(name = "menu_id")
    var menuid: Long? = null

}


/**
 * 商品秒杀产品表
 */
@Entity
@Table(name = "goods_seckill")
class GoodsSeckill {
    /**
     * 商品秒杀产品表id
     */
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null

    /**
     * 商品id
     */
    @Column(name = "goods_id")
    var goodsid: Long? = null

    /**
     * 推荐图
     */
    @Column(name = "pic_url")
    var picurl: String? = null

    /**
     * 轮播图
     */
    @Column(name = "images")
    var images: String? = null

    /**
     * 活动标题
     */
    @Column(name = "title")
    var title: String? = null

    /**
     * 简介
     */
    @Column(name = "info")
    var info: String? = null
    //decimal(10,2)//FIXME not support type getPrice() {
    //decimal(10,2)//FIXME not support type price) {
    /**
     * 价格
     */
    @Column(name = "price")
    var price // decimal(10,2)//FIXME not support type price;
            = 0.0

    //decimal(8,2)//FIXME not support type getCost() {
    //decimal(8,2)//FIXME not support type cost) {
    /**
     * 成本
     */
    @Column(name = "cost")
    var cost // decimal(8,2)//FIXME not support type cost;
            = 0.0

    //}  (10,2)//FIXME not support type getOriginprice() {
    // decimal(10,2)//FIXME not support type originprice) {
    /**
     * 原价
     */
    @Column(name = "origin_price")
    var originPrice //decimal(10,2)//FIXME not support type originPrice;
            = 0.0

    //} decimal(10,2)//FIXME not support type getGiveintegral() {
    /**
     * 返多少积分
     */
    @Column(name = "give_integral")
    var giveIntegral //decimal(10,2)//FIXME not support type giveIntegral;
            = 0.0

    /**
     * 排序
     */
    @Column(name = "sort")
    var sort: Int? = null

    /**
     * 库存
     */
    @Column(name = "stock")
    var stock: Int? = null

    /**
     * 销量
     */
    @Column(name = "sales")
    var sales = 0

    /**
     * 单位名
     */
    @Column(name = "unit_name")
    var unitname: String? = null

    /**
     * 内容
     */
    @Column(name = "description")
    var description: String? = null

    /**
     * 开始时间
     */
    @Column(name = "start_time")
    var starttime: Date? = null

    /**
     * 结束时间
     */
    @Column(name = "end_time")
    var endtime: Date? = null

    /**
     * 添加时间
     */
    @Column(name = "add_time")
    var addtime: Timestamp? = null

    /**
     * null
     */
    @Column(name = "upd_time")
    var updtime: Timestamp? = null

    /**
     * 产品状态
     */
    @Column(name = "status")
    var status: Int? = null

    /**
     * 删除 0未删除1已删除
     */
    @Column(name = "deleted")
    var deleted = 0

    /**
     * 最多秒杀几个
     */
    @Column(name = "max_num")
    var maxnum: Int? = null

    /**
     * 显示
     */
    @Column(name = "is_show")
    var isshow = 1

    /**
     * 时间段id
     */
    @Column(name = "time_id")
    var timeid = 0

    /**
     * 规格 0单 1多
     */
    @Column(name = "spec_type")
    var spectype: Int? = null

    /**
     * 运费模板id
     */
    @Column(name = "temp_id")
    var tempid: Int? = null

}