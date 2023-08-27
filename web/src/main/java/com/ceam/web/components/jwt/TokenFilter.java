package com.ceam.web.components.jwt;

import com.ceam.admin.vo.JwtUser;
import com.ceam.admin.vo.OnlineUser;
import com.ceam.common.utils.StringUtils;
import com.ceam.token.jwt.JwtTokenUtil;
import com.ceam.token.jwt.SecurityProperties;
import com.ceam.token.service.OnlineUserService;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author CeaM
 * 2023/01/28 12:21
 **/
@Slf4j
@Component
public class TokenFilter extends GenericFilterBean {

    private final JwtTokenUtil tokenUtil;
    private final OnlineUserService onlineUserService;
    private final SecurityProperties securityProperties;

    public TokenFilter(JwtTokenUtil tokenUtil,
                OnlineUserService onlineUserService,
                SecurityProperties securityProperties) {
        this.tokenUtil = tokenUtil;
        this.onlineUserService = onlineUserService;
        this.securityProperties = securityProperties;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        String requestRri = httpServletRequest.getRequestURI();
        log.info("requestUri==00[{}]", requestRri);

        // 验证 token 是否存在
        OnlineUser onlineUser = null;
        String authToken = "";
        try {
            authToken = tokenUtil.getToken(httpServletRequest);
            log.info("authToken0000[{}]", authToken);
            if (authToken == null) {
                chain.doFilter(httpServletRequest, response);
                return;
            }
            onlineUser = onlineUserService.getOne(securityProperties.getOnlineKey() + authToken);
        } catch (ExpiredJwtException e) {
            log.error(e.getMessage());
        }

        String username = StringUtils.isNotBlank(authToken) ? tokenUtil.getUsernameFromToken(authToken) : null;
        if (onlineUser != null && username != null && SecurityContextHolder.getContext().getAuthentication() == null
                && tokenUtil.validateToken(authToken)) {
            UserDetails userDetails = tokenUtil.getUserDetails(authToken);
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            log.debug("set Authentication to security context for '{}', uri: {}", authentication.getName(), requestRri);
        } else if (onlineUser != null && username != null && SecurityContextHolder.getContext().getAuthentication() != null
                && tokenUtil.validateToken(authToken) && !(SecurityContextHolder.getContext().getAuthentication() instanceof JwtUser)) {
            UserDetails userDetails = tokenUtil.getUserDetails(authToken);
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            log.debug("set Authentication to security context for '{}', uri: {}", authentication.getName(), requestRri);
        } else {
            tokenUtil.removeToken(authToken);
            log.debug("no valid JWT token found, uri: {}", requestRri);
        }
        chain.doFilter(httpServletRequest, response);
    }
}
