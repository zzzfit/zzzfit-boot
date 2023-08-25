apply(plugin = "org.springframework.boot")

dependencies {
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    compileOnly("javax.servlet:javax.servlet-api")

    implementation("org.slf4j:jul-to-slf4j")

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
    implementation("com.alibaba:druid-spring-boot-starter")
//    implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter")
    implementation("com.baomidou:mybatis-plus-boot-starter")

    implementation("com.baomidou:mybatis-plus")
//    implementation("com.baomidou:mybatis-plus-annotation")
    implementation("com.mysql:mysql-connector-j")

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

//tasks.jar {
//    manifest {
//        attributes(
//            "Main-Class" to "com.ceam.web.Application",
//        )
//    }
//    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
//    from(configurations.runtimeClasspath.get()
////        .filter { it.name != "sonar-application.jar" }
//        .map { if (it.isDirectory) it else zipTree(it) }
//    )
//}