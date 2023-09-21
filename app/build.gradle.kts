import org.springframework.boot.gradle.tasks.bundling.BootBuildImage

apply(plugin = "org.springframework.boot")
apply(plugin = "org.graalvm.buildtools.native")
apply(plugin = "org.springdoc.openapi-gradle-plugin")

dependencies {
    implementation("org.springframework.security:spring-security-web")
    implementation("org.springframework.security:spring-security-config")
    implementation("org.springframework.boot:spring-boot-autoconfigure")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-redis")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-logging")
    implementation("org.springframework.boot:spring-boot-actuator-autoconfigure")

    runtimeOnly("com.h2database:h2")
    implementation("com.mysql:mysql-connector-j")
    implementation("org.hibernate:hibernate-core")
    implementation("org.hibernate:hibernate-validator")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui")
    implementation("org.springframework.cloud:spring-cloud-commons")
    implementation("io.micrometer:micrometer-core")
    implementation("io.micrometer:micrometer-tracing-bridge-otel")

    implementation(project(":upms"))
    implementation(project(":data"))
    implementation(project(":web"))

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testImplementation("org.junit.jupiter:junit-jupiter-engine")
//    testImplementation("io.rest-assured:rest-assured")
    testImplementation("io.rest-assured:kotlin-extensions")
}

tasks.withType<BootBuildImage> {

}
