package com.ceam.sport.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author CeaM
 * 2023/02/19 23:11
 **/
@Data
public class CeamVipVO {

    private Long id;

    /**
     * 额度
     */
    private BigDecimal amount;

    /**
     * 1连续包月，2季卡，3年卡
     */
    private Integer type;

    /**
     * 状态
     */
    private Integer status;

    private String name;

    private String remark;

    /**
     * 逻辑删除
     */
    private Boolean deleted;

    /**
     * 打折，null不打折
     */
    private BigDecimal discount;

    /**
     * 打折后额度，逻辑字段
     */
    private BigDecimal discountAmount;

    /**
     * 0则不送
     */
    private Integer give;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime addTime;

    private Long addBy;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updTime;

    private Long updBy;

}
