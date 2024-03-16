
plugins {
	java
	id("org.springframework.boot") version "3.2.3"
	id("io.spring.dependency-management") version "1.1.4"
	kotlin("jvm")
}

group = "com.platzi"
version = "1.2"

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")

	//implementation("io.springfox:springfox-boot-starter:3.0.0")
	//compile("io.springfox:springfox-swagger-ui:3.0.0")

	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.1.0")

	runtimeOnly("org.postgresql:postgresql")

	implementation ("org.mapstruct:mapstruct:1.5.5.Final")
	annotationProcessor ("org.mapstruct:mapstruct-processor:1.5.5.Final")

	developmentOnly("org.springframework.boot:spring-boot-devtools")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	implementation(kotlin("stdlib-jdk8"))

}

tasks.withType<Test> {
	useJUnitPlatform()
}
kotlin {
	jvmToolchain(17)
}

// java -jar ubicacion/archivo