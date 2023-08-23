package com.ceam.sport.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author CeaM
 * @since 2023-02-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CeamComments implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
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

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updTime;

    private Long updBy;


}
