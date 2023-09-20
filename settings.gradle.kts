include("data", "upms", "platform", "web", "app")

pluginManagement {
    val kotlinVersion: String by settings
    val springBootVersion: String by extra
    val springCloudVersion: String by extra
    val hibernateVersion: String by extra

    plugins {
        id("io.spring.dependency-management").version("1.1.3").apply(false)
        id("org.springframework.boot").version(springBootVersion).apply(false)
        id("org.hibernate.orm").version(hibernateVersion).apply(false)
        kotlin("jvm").version(kotlinVersion).apply(false)
        kotlin("plugin.spring").version(kotlinVersion).apply(false)
        kotlin("plugin.jpa").version(kotlinVersion).apply(false)
        kotlin("plugin.allopen").version(kotlinVersion).apply(false)
        kotlin("plugin.noarg") .version(kotlinVersion).apply(false)
        kotlin("kapt").version(kotlinVersion).apply(false)
        id("org.springdoc.openapi-gradle-plugin").version("1.7.0").apply(false)
        id("org.graalvm.buildtools.native").version("0.9.27").apply(false)
        jacoco
        id("org.sonarqube").version("4.3.1.3277").apply(false)
    }
}