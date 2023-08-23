package com.ceam.sport.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author CeaM
 * 2023/02/18 22:07
 **/
@Data
public class CeamStoreDTO {

    private Long id;

    /**
     * 门店名称
     */
    private String name;

    /**
     * 联系手机号
     */
    private String phone;

    /**
     * 地址
     */
    private String address;

    /**
     * 联系人
     */
    private String username;

    /**
     * 经度
     */
    private BigDecimal latitude;

    /**
     * 纬度
     */
    private BigDecimal longitude;

    /**
     * 面积
     */
    private BigDecimal area;

    /**
     * 1运营中，2装修中，3停止运营
     */
    private Integer status;

    /**
     * 环境评分
     */
    private BigDecimal envScores;

    /**
     * 几颗星
     */
    private Integer star;

    /**
     * 评论数
     */
    private Integer comments;

    /**
     * 属性
     */
    private String attrs;

    /**
     * 门店logo
     */
    private String picUrl;

    /**
     * 开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime startTime;

    /**
     * 结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime endTime;

    /**
     * 服务评分
     */
    private BigDecimal serScores;

    /**
     * 设施评分
     */
    private BigDecimal facScores;

    /**
     * 设备，json数组
     */
    private String equipment;

}
