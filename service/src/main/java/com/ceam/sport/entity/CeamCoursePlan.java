package com.ceam.sport.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 排课
 * </p>
 *
 * @author CeaM
 * @since 2023-02-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CeamCoursePlan implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long storeId;
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
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
    private LocalDateTime startTime;

    /**
     * 结束时间
     */
    private LocalDateTime endTime;

    /**
     * 课程属性，json数组
     */
    private String attrs;

    private Boolean isShow;

    private String classroom;

    private Integer appointment;


}
