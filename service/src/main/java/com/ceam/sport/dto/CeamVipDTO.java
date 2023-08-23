package com.ceam.sport.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author CeaM
 * 2023/02/19 23:11
 **/
@Data
public class CeamVipDTO {

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

    /**
     * 逻辑删除
     */
    private Boolean deleted;

    /**
     * 打折
     */
    private BigDecimal discount;

    /**
     * 0则不送
     */
    private Integer give;

}
