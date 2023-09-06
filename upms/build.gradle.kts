dependencies {
    compileOnly("jakarta.servlet:jakarta.servlet-api")

    implementation("org.springframework:spring-orm")
    implementation("org.springframework:spring-webmvc")

    implementation("org.springframework.boot:spring-boot-starter-oauth2-resource-server")
    implementation("org.springframework.security:spring-security-oauth2-authorization-server")
    implementation(project(":data"))

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}