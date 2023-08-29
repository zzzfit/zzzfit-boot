import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension
import java.net.URI

buildscript {
    val kotlinVersion = "1.9.10"
    val springBootVersion = "3.1.3"
    val hibernateVersion = "6.2.7.Final"

    repositories {
        gradlePluginPortal()
        maven { url = java.net.URI("https://maven.aliyun.com/repository/central") }
    }

    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:$springBootVersion")
        classpath("org.hibernate.orm:hibernate-gradle-plugin:$hibernateVersion")
        classpath("io.spring.gradle:dependency-management-plugin:1.1.3")
        classpath("org.graalvm.buildtools:native-gradle-plugin:0.9.25")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
    }
}

allprojects {
    group = "cloud.zzzfit.boot"
    version = "0.0.1-SNAPSHOT"

    repositories {
        maven { url = URI("https://plugins.gradle.org/m2/") }
        maven { url = URI("https://maven.aliyun.com/repository/public") }
        maven { url = URI("https://maven.aliyun.com/repository/google") }
        maven { url = URI("https://maven.aliyun.com/repository/central") }
        maven { url = URI("https://maven.aliyun.com/repository/jcenter") }
        mavenCentral()
        google()
    }

    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "org.graalvm.buildtools.native")
    apply(plugin = "org.hibernate.orm")
//    apply(plugin = "org.jetbrains.kotlin.plugin.spring")
//    apply(plugin = "org.jetbrains.kotlin.plugin.jpa")
//    apply(plugin = "org.jetbrains.kotlin.plugin.allopen")

//    configurations {
//         compileOnly {
//            extendsFrom(configurations.annotationProcessor.get())
//        }
//    }

    configure<DependencyManagementExtension> {
        dependencies {
            dependency("org.springframework.security:spring-security-oauth2-authorization-server:1.1.2")
            dependency("org.projectlombok:lombok:1.18.20")

            dependency("com.fasterxml.jackson.core:jackson-annotations:2.14.0")
            dependency("com.fasterxml.jackson.core:jackson-core:2.14.0")
            dependency("com.fasterxml.jackson.core:jackson-databind:2.14.0")
            dependency("commons-codec:commons-codec:1.16.0")
            dependency("cn.hutool:hutool-all:5.8.21")
            dependency("eu.bitwalker:UserAgentUtils:1.21")
            dependency("javax.servlet:javax.servlet-api:4.0.1")
            dependency("javax.validation:validation-api:2.0.1.Final")

            dependency("com.alibaba:fastjson:2.0.39")

//            dependency("com.github.whvcse:easy-captcha:1.6.2")
//            dependency("com.sonsure:easy-captcha:1.6.2")

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

            dependency("org.springframework.security:spring-security-core:6.1.3")
            dependency("org.springframework.security:spring-security-config:6.1.3")
            dependency("org.springframework.security:spring-security-web:6.1.3")

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
            dependency("com.mysql:mysql-connector-j:8.1.0")
            dependency("ch.qos.logback:logback-classic:1.4.11")
            dependency("io.rest-assured:rest-assured:4.5.1")
//            dependency("javax.persistence:javax.persistence-api:2.2")
            dependency("org.freemarker:freemarker:2.3.29")

            dependency("com.alibaba:druid-spring-boot-starter:1.2.6")
            dependency("com.baomidou:mybatis-plus-boot-starter:3.5.3")
            dependency("com.baomidou:mybatis-plus:3.5.3")
            dependency("com.baomidou:mybatis-plus-core:3.5.3")
            dependency("com.baomidou:mybatis-plus-annotation:3.5.3")

            dependency("com.baomidou:mybatis-plus-extension:3.5.3")
            dependency("com.baomidou:dynamic-datasource-spring-boot-starter:3.5.3")
            dependency("com.baomidou:mybatis-plus-generator:3.5.3")
            dependency("com.h2database:h2:2.2.220")
            dependency("org.hibernate:hibernate-core:6.2.7.Final")
            dependency("org.hibernate:hibernate-validator:8.0.1.Final")

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


    tasks.withType<Test> {
        useJUnitPlatform()
    }

    tasks.withType<JavaCompile> {
        sourceCompatibility = "17"
        options.encoding = "UTF-8"
    }
}
