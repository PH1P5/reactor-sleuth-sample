import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.6.4"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	id("org.jetbrains.kotlin.jvm") version "1.6.10"
	id("org.jetbrains.kotlin.plugin.spring") version "1.6.10"
}

kotlin {
	jvmToolchain {
		(this as JavaToolchainSpec).languageVersion.set(JavaLanguageVersion.of(13))
	}
}

group = "de.phitho.samples"


// update gradle (always the ALL distribution) via
// ./gradlew wrapper --gradle-version 7.x.x
tasks.named<Wrapper>("wrapper") {
	distributionType = Wrapper.DistributionType.ALL
}

dependencyManagement {
	imports {
		mavenBom("org.springframework.cloud:spring-cloud-dependencies:2021.0.1")
	}
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-webflux")
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.cloud:spring-cloud-starter-sleuth")


	// kotlin related
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")


	// logging
	implementation("io.github.microutils:kotlin-logging")
	implementation("ch.qos.logback:logback-classic")
	implementation("net.logstash.logback:logstash-logback-encoder:7.0.1")
	implementation("org.codehaus.janino:janino")
	implementation("io.github.microutils:kotlin-logging:2.1.21")
	implementation("org.slf4j:log4j-over-slf4j")

	developmentOnly("org.springframework.boot:spring-boot-devtools")
}


tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
	}
}
repositories {
	mavenCentral()
}
