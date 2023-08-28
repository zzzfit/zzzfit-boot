dependencies {
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    compileOnly("jakarta.persistence:jakarta.persistence-api")

    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-data-rest")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    implementation("com.querydsl:querydsl-jpa")

    implementation(project(":service"))
    implementation(project(":common"))
    implementation(project(":core"))
    implementation("org.springframework:spring-context")
    implementation("org.springframework:spring-web")
    implementation("org.slf4j:slf4j-api")
    implementation("com.baomidou:mybatis-plus")
    implementation("com.baomidou:mybatis-plus-annotation")
    implementation("com.baomidou:mybatis-plus-extension")

    implementation("cn.hutool:hutool-all")

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
