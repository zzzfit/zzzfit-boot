FROM gradle:jdk17 as builder
COPY . /build/
RUN cd /build && gradle web:bootJar

FROM eclipse-temurin:17-jre
COPY --from=builder /build/web/build/libs/web-0.0.1-SNAPSHOT.jar /app.jar
WORKDIR /
CMD ["java", "-jar", "app.jar"]
