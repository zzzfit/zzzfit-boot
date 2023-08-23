package com.ceam.sport.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author CeaM
 * 2023/02/19 11:49
 **/
@Data
public class CeamHomeNavVO {

    private Long id;

    /**
     * 导航名称
     */
    private String navName;

    /**
     * 组件
     */
    private String component;

    /**
     * 图标
     */
    private String icon;

    private Boolean isShow;

    private Boolean deleted;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime addTime;

    private Long addBy;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updTime;

    private Long updBy;


}
