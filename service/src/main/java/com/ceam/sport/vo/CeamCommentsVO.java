package com.ceam.sport.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author CeaM
 * 2023/02/23 19:56
 **/
@Data
public class CeamCommentsVO {

    private Long id;

    /**
     * 会员ID
     */
    private Long customerId;

    /**
     * 评论对象ID
     */
    private Long objId;

    /**
     * 评论内容
     */
    private String description;

    /**
     * 评论图片，json数组
     */
    private String images;

    /**
     * 评论视频，json数组
     */
    private String videos;

    /**
     * 几颗星
     */
    private Integer star;

    /**
     * 门店ID
     */
    private Long storeId;

    /**
     * 1教练服务，2环境，3设备
     */
    private Integer type;

    /**
     * 评论时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDateTime addTime;

    /**
     * 是否显示
     */
    private Boolean isShow;

    /**
     * 是否匿名
     */
    private Boolean isAnon;

    /**
     * 如果匿名系统自动生成
     */
    private String customerName;

    private String customerAvatar;

}
