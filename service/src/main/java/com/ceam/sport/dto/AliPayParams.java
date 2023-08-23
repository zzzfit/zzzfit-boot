package com.ceam.sport.dto;

import lombok.Data;

@Data
public class AliPayParams {
    private String app_id;
    private String method;
    private String charset;
    private String sign_type;
    private String sign;
    private String timestamp;
    private String version;
    private String biz_content;
}
