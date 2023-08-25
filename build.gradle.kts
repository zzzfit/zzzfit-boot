import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import java.net.URI

plugins {
    id("org.springframework.boot") version "2.7.14"
    id("io.spring.dependency-management") version "1.1.3"
    kotlin("jvm") version "1.9.10"
    kotlin("plugin.spring") version "1.9.10"
    kotlin("plugin.jpa") version "1.9.10"
    kotlin("plugin.allopen") version "1.9.10"
}

allprojects {
    repositories {
        maven { url = URI("https://plugins.gradle.org/m2/") }
        maven { url = URI("https://maven.aliyun.com/repository/public") }
        maven { url = URI("https://maven.aliyun.com/repository/google") }
        maven { url = URI("https://maven.aliyun.com/repository/central") }
        maven { url = URI("https://maven.aliyun.com/repository/jcenter") }
        mavenCentral()
        google()
    }
}

subprojects {
    group = "cloud.zzzfit.boot"
    version = "0.0.1-SNAPSHOT"
//    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "org.jetbrains.kotlin.plugin.spring")
    apply(plugin = "org.jetbrains.kotlin.plugin.jpa")
    apply(plugin = "org.jetbrains.kotlin.plugin.allopen")

    java.sourceCompatibility = JavaVersion.VERSION_1_8

    configure<DependencyManagementExtension> {
        dependencies {
            dependency("org.springframework.boot:spring-boot-starter-parent:2.7.14")
            dependency("org.springframework.boot:spring-boot-starter-test:2.7.14")
            dependency("org.springframework.boot:spring-boot-starter-validation:2.7.14")
            dependency("org.springframework.boot:spring-boot-starter-quartz:2.7.14")
            dependency("org.springframework.boot:spring-boot-starter-data-redis:2.7.14")
            dependency("org.springframework.boot:spring-boot-starter-data-jpa:2.7.14")
            dependency("org.springframework.boot:spring-boot-autoconfigure:2.7.14")
            dependency("org.springframework.data:spring-data-commons:2.7.14")

            dependency("org.springframework.boot:spring-boot-autoconfigure:2.7.14")
            dependency("org.springframework.data:spring-data-redis:2.7.14")
            dependency("org.springframework.data:spring-data-commons:2.7.14")
            dependency("org.springframework.session:spring-session-data-redis:2.7.3")

            dependency("org.projectlombok:lombok:1.18.20")

            dependency("com.fasterxml.jackson.core:jackson-annotations:2.14.0")
            dependency("com.fasterxml.jackson.core:jackson-core:2.14.0")
            dependency("com.fasterxml.jackson.core:jackson-databind:2.14.0")
            dependency("commons-codec:commons-codec:1.16.0")
            dependency("cn.hutool:hutool-all:5.8.21")
//            dependency("com.alibaba.fastjson2:fastjson2:2.0.39")
            dependency("eu.bitwalker:UserAgentUtils:1.21")
            dependency("javax.servlet:javax.servlet-api:4.0.1")
            dependency("javax.validation:validation-api:2.0.1.Final")

            dependency("com.alibaba:fastjson:2.0.39")
            dependency("org.springframework:spring-web:5.3.29")
            dependency("org.springframework:spring-beans:5.3.29")
            dependency("org.springframework:spring-webmvc:5.3.29")

            dependency("com.github.whvcse:easy-captcha:1.6.2")

            dependency("org.springframework:spring-context:5.3.29")
            dependency("com.google.code.gson:gson:2.10")
            dependency("io.jsonwebtoken:jjwt:0.9.1")

            dependency("io.micrometer:micrometer-core:1.11.3")
            dependency("org.apache.commons:commons-lang3:3.13.0")
            dependency("com.google.guava:guava:32.1.2-jre")
            dependency("com.baomidou:mybatis-plus:3.2.0")
            dependency("com.baomidou:mybatis-plus-generator:3.2.0")
            dependency("com.baomidou:mybatis-plus-annotation:3.2.0")
            dependency("com.baomidou:mybatis-plus-core:3.5.3")
            dependency("com.baomidou:mybatis-plus-extension:3.5.3")

            dependency("org.springframework.security:spring-security-core:5.8.6")
            dependency("org.springframework.security:spring-security-config:5.8.6")
            dependency("org.springframework.security:spring-security-web:5.8.6")

//            dependency("org.springframework.cloud:spring-cloud-commons:3.0.4")
//            dependency("org.springframework.cloud:spring-cloud-context:3.0.4")
//            dependency("org.springframework.cloud:spring-cloud-starter-consul-discovery:3.0.4")
//            dependency("org.springframework.cloud:spring-cloud-starter-openfeign:3.0.4")
//            dependency("org.springframework.cloud:spring-cloud-openfeign-core:3.0.4")
//            dependency("org.springframework.cloud:spring-cloud-consul-discovery:3.0.4")
//
//            dependency("org.springframework.cloud:spring-cloud-starter-oauth2:2.2.5.RELEASE")
//            dependency("org.springframework.security.oauth:spring-security-oauth-parent:2.5.1.RELEASE")
//            dependency("org.springframework.security.oauth:spring-security-oauth-parent:2.5.1.RELEASE")
//
//            dependency("org.springframework.security.oauth:spring-security-oauth2:2.5.1.RELEASE")
//
//            dependency("org.mybatis.spring.boot:mybatis-spring-boot-starter:2.2.0")
            dependency("com.mysql:mysql-connector-j:8.1.0")

//            dependency("net.javacrumbs.shedlock:shedlock-spring:4.26.0")
//            dependency("net.javacrumbs.shedlock:shedlock-provider-redis-spring:4.26.0")
//            dependency("com.alibaba:fastjson:1.2.+")
            dependency("ch.qos.logback:logback-core:1.2.4")
            dependency("ch.qos.logback:logback-classic:1.2.4")
            dependency("org.slf4j:slf4j-api:1.7.32")
            dependency("org.slf4j:slf4j-simple:1.7.32")
            dependency("org.slf4j:jul-to-slf4j:1.7.32")



            dependency("io.rest-assured:rest-assured:4.5.1")
            dependency("javax.persistence:javax.persistence-api:2.2")
            dependency("org.freemarker:freemarker:2.3.29")

            dependency("com.alibaba:druid-spring-boot-starter:1.2.6")

            dependency("org.mybatis.spring.boot:mybatis-spring-boot-starter:2.3.1")
            dependency("com.baomidou:mybatis-plus-boot-starter:3.5.3.2")
            dependency("com.baomidou:mybatis-plus:3.5.3.2")
            dependency("com.baomidou:mybatis-plus-core:3.5.3.2")
            dependency("com.baomidou:mybatis-plus-extension:3.5.3.2")
            dependency("com.baomidou:dynamic-datasource-spring-boot-starter:3.5.3.2")
            dependency("com.baomidou:mybatis-plus-generator:3.5.3.2")
//
//            dependency("org.jgrapht:jgrapht-core:1.4.0")
//
//            dependency("org.fisco-bcos.java-sdk:fisco-bcos-java-sdk:2.8.0")
//            dependency("io.swagger:swagger-annotations:1.5.24")
//            dependency("io.springfox:springfox-swagger2:2.9.2")
//            dependency("io.springfox:springfox-swagger-ui:2.9.2")
//            dependency("com.google.guava:guava:30.1.1-jre")
//            dependency("com.cronutils:cron-utils:9.1.5")
//            dependency("p6spy:p6spy:3.9.1")
//            dependency("com.fasterxml.jackson.core:jackson-annotations:2.12.5")
//            dependency("com.fasterxml.jackson.core:jackson-databind:2.12.5")
//            dependency("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.12.5")
//            dependency("com.fasterxml.jackson.datatype:jackson-datatype-jdk8:2.12.5")
//            dependency("com.fasterxml.jackson.module:jackson-module-paranamer:2.12.5")
//
//            dependency("com.squareup.okhttp3:okhttp:4.9.1")
//            dependency("com.squareup.okhttp3:logging-interceptor:4.9.1")
//            dependency("io.github.openfeign:feign-jackson:11.6")
//            dependency("io.github.openfeign:feign-okhttp:11.6")
//            dependency("org.apache.httpcomponents:httpclient:4.5.13")
//            dependency("org.apache.skywalking:apm-agent-core:8.3.0")
//            dependency("org.apache.skywalking:apm-datacarrier:8.3.0")
//            dependency("org.apache.commons:commons-math3:3.6.1")
//            dependency("org.jpmml:pmml-evaluator:1.5.15")
//            dependency("io.reactivex.rxjava2:rxjava:2.2.21")
//
//            dependency("io.vertx:vertx-core:4.0.0")
//            dependency("io.vertx:vertx-web:4.0.0")
//            dependency("io.vertx:vertx-web-client:4.0.0")
//            dependency("io.vertx:vertx-rx-java2:4.0.0")
//
//            dependency("io.micrometer:micrometer-core:1.7.4")
//            dependency("com.jcraft:jsch:0.1.55")
//            dependency("com.github.ben-manes.caffeine:caffeine:2.8.8")
//            dependency("com.alibaba:easyexcel:2.2.11")
//            dependency("commons-beanutils:commons-beanutils:1.9.4")
//            dependency("com.opencsv:opencsv:5.5.2")
//            dependency("org.springframework.retry:spring-retry:1.3.1")
//            dependency("org.xbib.jdbc:jdbc-driver-csv:1.2.0")
//            dependency("javax.xml.bind:jaxb-api:2.3.1")
//            dependency("io.grpc:grpc-protobuf:1.40.1")
//            dependency("io.grpc:grpc-kotlin-stub:1.1.0")
//            dependency("io.grpc:grpc-core:1.40.1")
//            dependency("io.grpc:grpc-stub:1.40.1")
//            dependency("com.google.protobuf:protobuf-java:3.17.0")
//            dependency("org.quartz-scheduler:quartz:2.3.2")
//            dependency("com.google.code.gson:gson:2.8.8")
//            dependency("org.dom4j:dom4j:2.1.3")
        }
    }
//    tasks.withType<KotlinCompile> {
//        kotlinOptions {
//             freeCompilerArgs += "-Xjsr305=strict"
//            jvmTarget = "17"
//        }
//    }

//    tasks.withType<ProcessResources> {
//         duplicatesStrategy = DuplicatesStrategy.EXCLUDE
//    }
    tasks.withType<Test> {
        useJUnitPlatform()
    }

    tasks.withType<JavaCompile> {
        options.encoding = "UTF-8"
    }
}