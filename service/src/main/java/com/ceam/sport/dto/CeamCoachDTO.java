package com.ceam.sport.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author CeaM
 * 2023/02/18 21:51
 **/
@Data
public class CeamCoachDTO {

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
    private Integer teached;

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
    private String attrs;

    private String phone;

}
