dependencies {
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    implementation("jakarta.servlet:jakarta.servlet-api")

    implementation("com.google.code.gson:gson")
    implementation("io.jsonwebtoken:jjwt")
    implementation("org.springframework:spring-beans")
    implementation("org.springframework.security:spring-security-core")

    implementation("org.slf4j:slf4j-api")
    implementation("com.alibaba:fastjson")
    implementation("org.apache.commons:commons-lang3")

    implementation(project(":service"))
    implementation(project(":common"))
}