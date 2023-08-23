dependencies {
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    compileOnly("javax.servlet:javax.servlet-api")

    implementation("cn.hutool:hutool-all")

    implementation("com.fasterxml.jackson.core:jackson-annotations")
    implementation("com.baomidou:mybatis-plus")
    implementation("com.baomidou:mybatis-plus-annotation")
    implementation("org.springframework:spring-context")
    implementation("org.springframework.data:spring-data-commons")

    implementation("org.springframework:spring-web")
    implementation("com.github.whvcse:easy-captcha")
    implementation("org.springframework.security:spring-security-core")
    implementation("org.springframework.security:spring-security-config")
    implementation("org.apache.commons:commons-lang3")

    implementation(project(":service"))
    implementation(project(":common"))
    implementation(project(":jwt"))
}

//tasks.withType<KotlinCompile> {
//    kotlinOptions {
//        freeCompilerArgs += "-Xjsr305=strict"
//        jvmTarget = "17"
//    }
//}
//
//tasks.withType<Test> {
//    useJUnitPlatform()
//}
