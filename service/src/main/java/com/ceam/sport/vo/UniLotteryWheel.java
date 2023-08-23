package com.ceam.sport.vo;

import lombok.Data;

@Data
public class UniLotteryWheel {

    private String id;

    /**
     * 名称
     */
    private String name;

    /**
     * 奖品内容
     */
    private String content;

    /**
     * 背景颜色
     */
    private String backgroundColor;

    /**
     * 字体颜色
     */
    private String color;

    /**
     * 奖品图片
     */
    private String src;
}
