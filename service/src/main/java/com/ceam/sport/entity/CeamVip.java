package com.ceam.sport.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 会员卡
 * </p>
 *
 * @author CeaM
 * @since 2023-02-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CeamVip implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
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

    private String name;

    private String remark;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime addTime;

    private Long addBy;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updTime;

    private Long updBy;


}
