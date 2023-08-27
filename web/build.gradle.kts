apply(plugin = "org.springframework.boot")

dependencies {
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    implementation("jakarta.servlet:jakarta.servlet-api")

    implementation("org.springframework.security:spring-security-core")
    implementation("org.springframework.security:spring-security-web")
    implementation("org.springframework.security:spring-security-config")
    implementation("io.jsonwebtoken:jjwt")
    implementation("org.springframework:spring-webmvc")
    implementation("com.baomidou:mybatis-plus-annotation")
    implementation("com.baomidou:mybatis-plus-extension")
    implementation("org.springframework.boot:spring-boot-autoconfigure")
    implementation("org.apache.commons:commons-lang3")

    implementation("org.springframework.data:spring-data-redis")
    implementation("org.springframework.session:spring-session-data-redis")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-redis")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-logging")
    implementation("org.springframework.boot:spring-boot-starter-oauth2-resource-server")
    implementation("org.springframework.security:spring-security-oauth2-authorization-server")

    implementation("com.h2database:h2")

    implementation("com.alibaba:druid-spring-boot-starter")
    implementation("com.baomidou:mybatis-plus-boot-starter")
    implementation("com.baomidou:mybatis-plus")

    implementation("com.mysql:mysql-connector-j")
    implementation("org.hibernate:hibernate-core")
    implementation("org.hibernate:hibernate-validator")

    implementation(project(":core"))
    implementation(project(":service"))
    implementation(project(":common"))
    implementation(project(":jwt"))
    implementation(project(":admin"))
    implementation(project(":sport"))

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testImplementation("org.junit.jupiter:junit-jupiter-engine")
    testImplementation("io.rest-assured:rest-assured")
}