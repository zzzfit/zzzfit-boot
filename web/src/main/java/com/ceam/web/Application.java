package com.ceam.web;

import com.ceam.common.utils.ApplicationContextHolder;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * 腾讯位置服务https://lbs.qq.com/getPoint/
 * https://www.showdoc.com.cn/
 *
 * @author CeaM
 * 2023/01/27 09:44
 **/
//@SpringBootApplication(
//        scanBasePackages = {"com.ceam", "com.ceam.web.config"})
@Configuration
@EnableAutoConfiguration
@ComponentScan(
        basePackages = {"com.ceam"}
)
@EnableJpaRepositories(
        basePackages = {"com.ceam.core"}
)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

//    @Bean
//    public ApplicationContextHolder springContextHolder() {
//        return new ApplicationContextHolder();
//    }
}
