import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    war
    id("org.springframework.boot") version "3.1.0"
    id("io.spring.dependency-management") version "1.1.0"
    kotlin("jvm") version "1.8.21"
    kotlin("plugin.spring") version "1.8.21"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-security")
    runtimeOnly("org.hsqldb:hsqldb")
    testImplementation("org.springframework.security:spring-security-test")

    implementation("org.springframework.boot:spring-boot-starter-web")
    providedRuntime("org.springframework.boot:spring-boot-starter-tomcat")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    // Spring
    implementation("org.springframework:spring-webmvc:6.0.6")
    // Thymeleaf
    implementation("org.thymeleaf:thymeleaf-spring6:3.1.1.RELEASE")
    // Jetty & Servlet API
    implementation("org.eclipse.jetty:jetty-webapp:11.0.14")
    compileOnly("jakarta.servlet:jakarta.servlet-api:6.0.0")

    // Logging
    implementation("org.apache.logging.log4j:log4j-core:2.20.0")
    implementation("org.apache.logging.log4j:log4j-slf4j2-impl:2.20.0")

    // Spring Data
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.8.0")
    implementation("org.springframework.data:spring-data-jpa:3.0.3")

    // Hibernate
    implementation("org.hibernate:hibernate-core:6.1.7.Final")

    // In Memory DB
    implementation("org.hsqldb:hsqldb:2.7.1")

    // Jackson
    implementation("com.fasterxml.jackson.core:jackson-databind:2.14.2")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.14.2")

    testImplementation(kotlin("test"))
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}
