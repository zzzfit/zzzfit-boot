package com.ceam.admin.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author CeaM
 * 2023/01/29 11:03
 **/
@Data
public class CeamSysDictVO {

    private Long id;

    /**
     * 字典名称
     */
    private String name;

    /**
     * 描述
     */
    private String remark;

    /**
     * 创建日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime addTime;

    private LocalDateTime updTime;

    private Boolean deleted;
}
