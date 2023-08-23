package com.ceam.sport.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author CeaM
 * 2023/02/23 19:57
 **/
@Data
public class CeamCommentsDTO {

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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime addTime;

    private Boolean isShow;

}
