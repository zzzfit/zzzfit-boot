package com.ceam.token.jwt;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author CeaM
 * 2023/01/28 12:24
 **/
@Data
@Configuration(proxyBeanMethods = false)
public class SecurityProperties {

    @Value("${jwt.token-header:Authorization}")
    private String header;

    @Value("${jwt.token-start-with:Bearer}")
    private String tokenStartWith;

    @Value("${jwt.base64-secret}")
    private String base64Secret;

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.validity:36000000}")
    private Long validity;

    @Value("${jwt.online-key}")
    private String onlineKey;

    @Value("${jwt.code-key}")
    private String codeKey;

    public String getTokenStartWith() {
        return tokenStartWith + " ";
    }
}
