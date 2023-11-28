import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension
import org.jetbrains.kotlin.gradle.plugin.extraProperties
import org.jetbrains.kotlin.gradle.tasks.Kapt
import org.springframework.boot.gradle.tasks.bundling.BootBuildImage

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.sonarqube.gradle.SonarExtension
import org.sonarqube.gradle.SonarTask
import java.net.URI

val springBootVersion: String by extra
val springCloudVersion: String by extra
val springSecurityVersion: String by extra
val hibernateVersion: String by extra
//val queryDslVersion: String by extra

plugins {
    id("io.spring.dependency-management").apply(false)
    id("org.springframework.boot").apply(false)
    id("org.hibernate.orm").apply(false)
    kotlin("jvm").apply(false)
    kotlin("plugin.spring").apply(false)
    kotlin("plugin.jpa").apply(false)
    kotlin("plugin.allopen").apply(false)
    kotlin("plugin.noarg").apply(false)
    kotlin("kapt").apply(false)
    id("org.springdoc.openapi-gradle-plugin").apply(false)
    id("org.graalvm.buildtools.native").apply(false)
    jacoco
    id("org.sonarqube").apply(false)
}

subprojects {
    group = "cloud.zzzfit"
    version = "0.0.1-SNAPSHOT"

    apply(plugin = "java")
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "org.hibernate.orm")
    apply(plugin = "org.jetbrains.kotlin.plugin.spring")
    apply(plugin = "org.jetbrains.kotlin.plugin.jpa")
    apply(plugin = "org.jetbrains.kotlin.plugin.noarg")
    apply(plugin = "org.jetbrains.kotlin.plugin.allopen")
    apply(plugin = "org.jetbrains.kotlin.kapt")
    apply(plugin = "jacoco")
    apply(plugin = "org.sonarqube")

    repositories {
        maven { url = URI("https://plugins.gradle.org/m2/") }
        maven { url = URI("https://maven.aliyun.com/repository/public") }
        maven { url = URI("https://maven.aliyun.com/repository/google") }
        maven { url = URI("https://maven.aliyun.com/repository/central") }
        maven { url = URI("https://maven.aliyun.com/repository/jcenter") }
        mavenCentral()
        google()
    }

    configure<DependencyManagementExtension> {
        dependencies {
            imports {
                mavenBom("org.springframework.boot:spring-boot-dependencies:${springBootVersion}")
                mavenBom("org.springframework.cloud:spring-cloud-dependencies:$springCloudVersion")
                mavenBom("io.micrometer:micrometer-bom:1.11.3")
            }
            dependency("org.springframework.security:spring-security-oauth2-authorization-server:1.1.2")
            dependency("org.projectlombok:lombok:1.18.20")
//            dependency("com.fasterxml.jackson.core:jackson-annotations:2.14.0")
//            dependency("com.fasterxml.jackson.core:jackson-core:2.14.0")
//            dependency("com.fasterxml.jackson.core:jackson-databind:2.14.0")
//            dependency("commons-codec:commons-codec:1.16.0")
//            dependency("cn.hutool:hutool-all:5.8.21")
//            dependency("eu.bitwalker:UserAgentUtils:1.21")

//            dependency("com.alibaba:fastjson:2.0.39")
//            dependency("com.google.code.gson:gson:2.10")

//            dependency("org.apache.commons:commons-lang3:3.13.0")
//            dependency("com.google.guava:guava:32.1.2-jre")
            dependency("org.springframework.security:spring-security-core:$springSecurityVersion")
            dependency("org.springframework.security:spring-security-config:$springSecurityVersion")
            dependency("org.springframework.security:spring-security-web:$springSecurityVersion")

            dependency("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.2.0")
            dependency("org.springdoc:springdoc-openapi-ui:1.7.0")

//            dependency("org.springframework.cloud:spring-cloud-commons:3.0.4")
//            dependency("org.springframework.cloud:spring-cloud-context:3.0.4")
//            dependency("org.springframework.cloud:spring-cloud-starter-consul-discovery:3.0.4")
//            dependency("org.springframework.cloud:spring-cloud-starter-openfeign:3.0.4")
//            dependency("org.springframework.cloud:spring-cloud-openfeign-core:3.0.4")
//            dependency("org.springframework.cloud:spring-cloud-consul-discovery:3.0.4")

            dependency("com.mysql:mysql-connector-j:8.1.0")
//            dependency("ch.qos.logback:logback-classic:1.4.11")
//            dependency("org.freemarker:freemarker:2.3.29")

            dependency("com.h2database:h2:2.2.220")
            dependency("org.hibernate:hibernate-core:$hibernateVersion")
            dependency("org.hibernate:hibernate-validator:8.0.1.Final")

//            dependency("com.querydsl:querydsl-core:$queryDslVersion")
//            dependency("com.querydsl:querydsl-jpa:$queryDslVersion")
//            dependency("com.querydsl:querydsl-kotlin-codegen:$queryDslVersion")
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }

    tasks.withType<JavaCompile> {
        sourceCompatibility = "17"
        options.encoding = "UTF-8"
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf(
                "-Xjsr305=strict",
                "-Xjvm-default=all-compatibility"
            )
            jvmTarget = "17"
        }
    }

    tasks.withType<JacocoReport> {
        dependsOn(tasks.withType<Test>())
        reports.xml.required = true
    }

    configure<SonarExtension> {
        properties {
            property("sonar.projectKey", "${rootProject.name}-${project.name}")
            property("sonar.projectName", "${rootProject.name}-${project.name}")
            property ("sonar.organization", System.getenv("SONAR_ORGANIZATION") ?: "")
            property ("sonar.host.url", System.getenv("SONAR_HOST_URL") ?: "")
            property ("sonar.token", System.getenv("SONAR_TOKEN") ?: "")
        }
    }
}
