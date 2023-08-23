package com.ceam.sport.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CeamLotteryWheelVO {

    private String activityName;
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 奖品内容
     */
    private String content;

    /**
     * 背景颜色
     */
    private String bgColor;

    /**
     * 字体颜色
     */
    private String color;

    /**
     * 奖品图片
     */
    private String picUrl;

    private Long activityId;

    private Boolean deleted;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime addTime;

    private Long addBy;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updTime;

    private Long updBy;
}
