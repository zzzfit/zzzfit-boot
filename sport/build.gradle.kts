dependencies {
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    compileOnly("javax.servlet:javax.servlet-api")

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
