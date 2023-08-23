package com.ceam.mall.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author CeaM
 * 2023/02/03 20:43
 **/
@Data
public class CeamGoodsBargainDTO {

    private Long id;

    /**
     * 关联产品ID
     */
    private Long goodsId;

    /**
     * 砍价活动名称
     */
    private String title;

    /**
     * 砍价活动图片
     */
    private String picUrl;

    /**
     * 单位名称
     */
    private String unitName;

    /**
     * 库存
     */
    private Integer stock;

    /**
     * 销量
     */
    private Integer sales;

    /**
     * 砍价产品轮播图
     */
    private String images;

    /**
     * 砍价开启时间
     */
    private LocalDateTime startTime;

    /**
     * 砍价结束时间
     */
    private LocalDateTime endTime;

    /**
     * 砍价产品名称
     */
    private String storeName;

    /**
     * 砍价金额
     */
    private BigDecimal price;

    /**
     * 砍价商品最低价
     */
    private BigDecimal minPrice;

    /**
     * 每次购买的砍价产品数量
     */
    private Integer num;

    /**
     * 用户每次砍价的最大金额
     */
    private BigDecimal bargainMaxPrice;

    /**
     * 用户每次砍价的最小金额
     */
    private BigDecimal bargainMinPrice;

    /**
     * 用户每次砍价的次数
     */
    private Integer bargainNum;

    /**
     * 砍价状态 0(到砍价时间不自动开启)  1(到砍价时间自动开启时间)
     */
    private Integer status;

    /**
     * 砍价详情
     */
    private String description;

    /**
     * 反多少积分
     */
    private BigDecimal giveIntegral;

    /**
     * 砍价活动简介
     */
    private String info;

    /**
     * 成本价
     */
    private BigDecimal cost;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 是否删除 0未删除 1删除
     */
    private Integer deleted;

    /**
     * 添加时间
     */
    private LocalDateTime addTime;

    private LocalDateTime updTime;

    /**
     * 砍价规则
     */
    private String rule;

    /**
     * 砍价产品浏览量
     */
    private Integer look;

    /**
     * 砍价产品分享量
     */
    private Integer share;

}
