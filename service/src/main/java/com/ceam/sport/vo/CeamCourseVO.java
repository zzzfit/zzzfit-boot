package com.ceam.sport.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author CeaM
 * 2023/02/20 19:31
 **/
@Data
public class CeamCourseVO {

    private Long id;

    private String name;

    private Integer type;

    private Boolean deleted;

    private Integer status;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime addTime;

    private Long addBy;

    private Long updBy;

    private Integer taught;

    private Integer time;

    private Integer affect;

    private Integer difficulty;

    private Integer calories;

    private String video;
}
