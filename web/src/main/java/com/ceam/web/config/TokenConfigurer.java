package com.ceam.web.config;

import com.ceam.token.jwt.JwtTokenUtil;
import com.ceam.token.jwt.SecurityProperties;
import com.ceam.token.service.OnlineUserService;
import com.ceam.web.components.jwt.TokenFilter;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class TokenConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    private final JwtTokenUtil tokenUtil;
    private final OnlineUserService onlineUserService;
    private final SecurityProperties securityProperties;

    public TokenConfigurer(JwtTokenUtil tokenUtil,
                           OnlineUserService onlineUserService,
                           SecurityProperties securityProperties){
        this.tokenUtil = tokenUtil;
        this.onlineUserService = onlineUserService;
        this.securityProperties = securityProperties;
    }

    @Override
    public void configure(HttpSecurity http) {
        TokenFilter customFilter = new TokenFilter(tokenUtil, onlineUserService, securityProperties);
        http.addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
