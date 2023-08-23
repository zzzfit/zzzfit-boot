package com.ceam.sport.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author CeaM
 * 2023/02/18 21:47
 **/
@Data
public class CeamCoachVO {

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

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime addTime;

    private Long addBy;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updTime;

    private Long updBy;

    private String signature;

}
