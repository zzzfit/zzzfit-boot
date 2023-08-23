package com.ceam.mall.vo;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author CeaM
 * 2023/01/29 23:07
 **/
@Data
public class CeamGoodsCategoryVO {

    private Long id;

    /**
     * 父id
     */
    private Long pid;

    /**
     * 分类名称
     */
    private String cateName;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 图标
     */
    private String pic;

    /**
     * 是否推荐
     */
    private Boolean isShow;

    /**
     * 添加时间
     */
    private LocalDateTime addTime;

    private LocalDateTime updTime;

    /**
     * 删除状态
     */
    private Boolean deleted;

    private List<CeamGoodsCategoryVO> children;

    public String getLabel() {
        return cateName;
    }

}
