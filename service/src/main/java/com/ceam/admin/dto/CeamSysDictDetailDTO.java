package com.ceam.admin.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author CeaM
 * 2023/01/29 21:19
 **/
@Data
public class CeamSysDictDetailDTO {

    private Long id;

    /**
     * 字典标签
     */
    private String label;

    /**
     * 字典值
     */
    private Integer value;

    /**
     * 排序
     */
    private String sort;

    /**
     * 字典id
     */
    private Long dictId;

    /**
     * 创建日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime addTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updTime;

    private Boolean deleted;

    private String dictName;
}
