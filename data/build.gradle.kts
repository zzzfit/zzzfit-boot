dependencies {
    compileOnly("jakarta.persistence:jakarta.persistence-api")
    compileOnly("jakarta.validation:jakarta.validation-api")

    implementation("com.fasterxml.jackson.core:jackson-databind")
    implementation("org.springframework.data:spring-data-jpa")
    implementation("org.hibernate.orm:hibernate-spatial")
    implementation("com.querydsl:querydsl-core")
    implementation("com.querydsl:querydsl-jpa")

    kapt("com.querydsl:querydsl-apt:${property("queryDslVersion")}:jakarta")

    testImplementation("com.h2database:h2")
    testImplementation("org.springframework:spring-aspects")
    testRuntimeOnly("org.jetbrains.kotlin:kotlin-reflect")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testImplementation("org.junit.jupiter:junit-jupiter-engine")
}

allOpen {
    annotation("jakarta.persistence.Entity")
    annotation("jakarta.persistence.MappedSuperclass")
    annotation("jakarta.persistence.Embeddable")
}