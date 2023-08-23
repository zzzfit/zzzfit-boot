package com.ceam.sport.map;

import com.ceam.sport.entity.CeamCoursePlan;
import com.ceam.sport.vo.CeamCommentsVO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * CeamCoursePlan结果集映射
 *
 * @author CeaM
 * 2023/02/25 18:40
 **/
@Data
public class CoursePlanResultMap {

    private static final long serialVersionUID = 1L;

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
     * 课程属性，json数组
     */
    private String attrs;

    private Boolean isShow;

    private String classroom;

    private Integer appointment;

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

    private String monthDay;

    private String signature;

    private BigDecimal originPrice;

    private String video;

    private List<CeamCommentsVO> comments;

}
