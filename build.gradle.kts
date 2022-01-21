import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.6.2"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("jvm") version "1.6.10"
	kotlin("plugin.spring") version "1.6.10"

	//Islam Custom
	kotlin("plugin.serialization") version "1.6.10"
}

java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-r2dbc:2.5.6")
	implementation("org.springframework.boot:spring-boot-starter-data-rest:2.6.1")
	implementation("org.springframework.boot:spring-boot-starter-validation:2.6.1")
	implementation("org.springframework.boot:spring-boot-starter-web:2.6.1")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.1")
	implementation("io.projectreactor.kotlin:reactor-kotlin-extensions:1.1.5")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2-native-mt")

	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor:1.5.2-native-mt")

	implementation("dev.miku:r2dbc-mysql:0.8.2.RELEASE")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.6.1")
	implementation("mysql:mysql-connector-java:8.0.25")
	testImplementation("org.springframework.boot:spring-boot-starter-test:2.6.1")
	testImplementation("io.projectreactor:reactor-test:3.4.13")

	implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")
	implementation ("com.google.code.gson:gson:2.8.7")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
