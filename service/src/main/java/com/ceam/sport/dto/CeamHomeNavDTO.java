package com.ceam.sport.dto;

import lombok.Data;

/**
 * @author CeaM
 * 2023/02/19 11:49
 **/
@Data
public class CeamHomeNavDTO {

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


}
