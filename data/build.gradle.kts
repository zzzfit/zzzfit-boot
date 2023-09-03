dependencies {
    compileOnly("jakarta.persistence:jakarta.persistence-api")
    implementation("com.fasterxml.jackson.core:jackson-databind")
    implementation("org.springframework.data:spring-data-jpa")
    implementation("com.querydsl:querydsl-jpa:${property("queryDslVersion")}:jakarta")
//    kapt("com.querydsl:querydsl-apt:${property("queryDslVersion")}:jakarta")
}
