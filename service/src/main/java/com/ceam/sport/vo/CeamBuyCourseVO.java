package com.ceam.sport.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author CeaM
 * 2023/02/23 11:23
 **/
@Data
public class CeamBuyCourseVO {


    private BigDecimal latitude;
    private BigDecimal longitude;





    private Long id;

    /**
     * 教练ID
     */
    private Long coachId;

    /**
     * 课程ID
     */
    private Long courseId;

    /**
     * 是否开放
     */
    private Boolean isOpen;

    /**
     * 周几
     */
    private Long tabId;

    /**
     * 开始时间
     */
    @JsonFormat(pattern = "HH:mm", timezone = "GMT+8")
    private LocalDateTime startTime;

    /**
     * 结束时间
     */
    @JsonFormat(pattern = "HH:mm", timezone = "GMT+8")
    private LocalDateTime endTime;

    /**
     * 课程属性，json数组
     */
    private String attrs;

    private Integer weekday;

    private String weekName;

    private String coachName;

    private String coachAvatar;

    private String courseName;

    private Integer minTime;

    private String affect;

    private String difficulty;

    private Integer calories;

    private String storeName;

    private String classroom;

    private Integer appointment;

    private String monthDay;

    private String signature;

    private BigDecimal originPrice;

    private String video;

    List<CeamCommentsVO> comments;
}
