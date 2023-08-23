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
 * 教练表
 * </p>
 *
 * @author CeaM
 * @since 2023-02-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CeamCoach implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 授课单价
     */
    private BigDecimal unitPrice;

    /**
     * 好评
     */
    private Integer review;

    /**
     * 已经教过多少人
     */
    private Integer taught;

    /**
     * 现在教多少人
     */
    private Integer teaching;

    /**
     * 头像
     */
    private String avatar;

    /**
     * json数组
     */
    private String[] attrs;

    /**
     * 所在门店
     */
    private Long storeId;

    private Boolean deleted;

    private String phone;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime addTime;

    private Long addBy;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updTime;

    private Long updBy;

    private String signature;
}
