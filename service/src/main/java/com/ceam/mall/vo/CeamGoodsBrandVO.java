package com.ceam.mall.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author CeaM
 * 2023/02/08 18:42
 **/
@Data
public class CeamGoodsBrandVO {

    private Long id;

    /**
     * 品牌商名称
     */
    private String name;

    /**
     * 品牌商简介
     */
    private String brandsDesc;

    /**
     * 品牌商页的品牌商图片
     */
    private String picUrl;

    private Integer sortOrder;

    /**
     * 品牌商的商品低价，仅用于页面展示
     */
    private BigDecimal floorPrice;

    /**
     * 创建时间
     */
    private LocalDateTime addTime;

    /**
     * 更新时间
     */
    private LocalDateTime updeTime;

    /**
     * 分享二维码图片
     */
    private String shareUrl;

    /**
     * 管理用户id
     */
    private Long addBy;

    /**
     * 逻辑删除
     */
    private Boolean deleted;

    private String commpany;

    /**
     * 自动监控更新商品
     */
    private Boolean autoUpdateGood;

    /**
     * 店铺url地址
     */
    private String shopUrl;

    /**
     * 默认的商品类别id
     */
    private Long defaultCateId;

    /**
     * 默认商品页面数
     */
    private Integer defaultPages;

    /**
     * 店铺商品溢价
     */
    private Integer addPrecent;

    /**
     * 提货地址
     */
    private String address;

    /**
     * 经度
     */
    private BigDecimal longitude;

    /**
     * 纬度
     */
    private BigDecimal latitude;

    /**
     * 提货时间配置
     */
    private String fetchTimeRules;

}
