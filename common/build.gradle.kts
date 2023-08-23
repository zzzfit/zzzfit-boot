dependencies {
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    compileOnly("javax.servlet:javax.servlet-api")

    implementation("commons-codec:commons-codec")
    implementation("com.fasterxml.jackson.core:jackson-annotations")
    implementation("cn.hutool:hutool-all")
    implementation("com.alibaba:fastjson")
    implementation("org.springframework:spring-web")
    implementation("io.micrometer:micrometer-core")
    implementation("org.springframework.boot:spring-boot-autoconfigure")
    implementation("org.springframework.data:spring-data-redis")
    implementation("eu.bitwalker:UserAgentUtils")
    implementation("org.apache.commons:commons-lang3")
    implementation("com.google.guava:guava")
    implementation("com.baomidou:mybatis-plus")
    implementation("org.springframework.security:spring-security-core")
    implementation("org.slf4j:slf4j-api:1.7.32")
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
