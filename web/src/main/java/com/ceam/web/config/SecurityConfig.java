package com.ceam.web.config;

import com.ceam.token.jwt.JwtTokenUtil;
import com.ceam.token.jwt.SecurityProperties;
import com.ceam.token.service.OnlineUserService;
import com.ceam.web.components.JwtAccessDeniedHandler;
import com.ceam.web.components.JwtAuthenticationEntryPoint;
import com.ceam.web.components.jwt.TokenFilter;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author CeaM
 * 2023/01/20 10:03
 **/
@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {

    private final JwtTokenUtil tokenUtil;
    private final TokenFilter tokenFilter;
    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final OnlineUserService onlineUserService;
    private final SecurityProperties securityProperties;

    /**
     * 白名单
     */
    private static final String[] whitePath = {"/api/auth/attention", "/api/commercial", "/menu/build",
            "/api/home", "/api/auth/login", "/api/auth/code", "/api/store/appList", "/api/lotteryActivity",

            "/api/coursePlan", "/api/store/detail", "/api/coursePlan/toPay", "/api/wheel/uni",
            "/client/**", "/api/auth/logout", "/webjars/**", "/oauth/token", "/oauth/authorize"};

    private static final String[] staticResources = {"/favicon.ico", "/static/**"};

    @Bean
    public PasswordEncoder passwordEncoder() {
        // 密码加密方式
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // 版本不同可能顺序不同Can't configure antMatchers after anyRequest
        return http
                .authorizeHttpRequests((authorizeHttpRequests) ->
                        authorizeHttpRequests
                                .requestMatchers(ArrayUtils.addAll(
                                        whitePath, staticResources)).permitAll()
                                // 不拦截option请求
                                .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                )
                // 关闭服务器端渲染页面
                .csrf(AbstractHttpConfigurer::disable)
                .httpBasic(basic -> basic.authenticationEntryPoint(jwtAuthenticationEntryPoint))
                .exceptionHandling(h -> h.accessDeniedHandler(jwtAccessDeniedHandler))

//                // 避免前后端Session不一致
//                .and()
                .sessionManagement(
                        s -> s.
                                sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                                // 关闭Spring Security 的Session
                                .sessionFixation().changeSessionId().disable()
                )
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                // 关闭Spring Security 的Session
//                .sessionFixation().changeSessionId().disable()
                .formLogin(f -> f.loginPage("/login").permitAll())
//                .authorizeRequests()
//                .anyRequest().authenticated()

//                .and()
//                .apply(securityConfigurerAdapter())
//                .and()
                .build();
//                .and()
//                .build()

//        http.build();
    }


    private TokenConfigurer securityConfigurerAdapter() {
        return new TokenConfigurer(tokenUtil, onlineUserService, securityProperties);
    }
}
