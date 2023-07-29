import com.google.protobuf.gradle.id
import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    dependencies {
        classpath(libs.kotlin.gradle.plugin)
    }
}

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("application")
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.kotlin.spring)
    alias(libs.plugins.spring.boot)
    alias(libs.plugins.spring.management)
    alias(libs.plugins.protobuf.gradle)
}

group = "com.example.app"
version = "0.0.1-SNAPSHOT"

kotlin {
    jvmToolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

protobuf {
    protoc {
        artifact = libs.protobuf.protoc.get().toString()
    }
    plugins {
        id("grpc") {
            artifact = libs.grpc.protoc.gen.get().toString() +
                    ":" + libs.versions.grpc.get().toString()
        }
    }
    generateProtoTasks {
        ofSourceSet("grpc").forEach {
            it.plugins {
                it.plugins {
                    id("grpc") { }
                }
            }
        }
    }
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
    testCompileOnly {
        extendsFrom(configurations.testAnnotationProcessor.get())
    }
}

dependencies {
    implementation(platform(libs.spring.boot.bom))
    implementation(project(mapOf("path" to ":shared")))
    implementation(libs.spring.boot.webflux)
    implementation(libs.spring.boot.data.r2dbc)
    implementation(libs.spring.boot.data.redis.reactive)
    implementation(libs.spring.boot.validation)
    implementation(libs.spring.boot.actuator)
    implementation(libs.kotlin.stdlib)
    implementation(libs.reactor.kotlin)
    runtimeOnly(libs.micrometer.prometheus)
    runtimeOnly(libs.r2dbc.mysql)
    testImplementation(libs.spring.boot.test)
    testImplementation(libs.reactor.test)

    // grpc
    implementation(platform(libs.grpc.bom))
    implementation(libs.grpc.protobuf)
    implementation(libs.grpc.stub)
    runtimeOnly(libs.grpc.netty.shaded)
    compileOnly(libs.tomcat.annotations.api)
}

tasks {
    withType<JavaCompile> {
        options.encoding = "UTF-8"
    }
    withType<KotlinCompile> {
        compilerOptions {
            freeCompilerArgs.set(listOf("-Xjsr305=strict"))
        }
    }
    withType<Test> {
        useJUnitPlatform()
        testLogging {
            events(
                TestLogEvent.FAILED,
                TestLogEvent.PASSED,
                TestLogEvent.SKIPPED
            )
            debug {
                events(
                    TestLogEvent.FAILED,
                    TestLogEvent.PASSED,
                    TestLogEvent.SKIPPED,
                    TestLogEvent.STANDARD_OUT,
                    TestLogEvent.STANDARD_ERROR
                )
                showStackTraces = true
                exceptionFormat = TestExceptionFormat.FULL
            }
        }
    }
    processResources {
        duplicatesStrategy = DuplicatesStrategy.INCLUDE
    }
}
