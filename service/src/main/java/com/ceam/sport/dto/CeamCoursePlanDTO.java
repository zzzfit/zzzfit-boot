package com.ceam.sport.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author CeaM
 * 2023/02/18 22:29
 **/
@Data
public class CeamCoursePlanDTO {

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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime startTime;

    /**
     * 结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime endTime;

    /**
     * 课程属性，json数组
     */
    private String attrs;

}
