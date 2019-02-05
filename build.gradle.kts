import com.jfrog.bintray.gradle.BintrayExtension

plugins {
    `maven-publish`
    id("com.jfrog.bintray") version "1.8.1"
    id("io.spring.dependency-management") version "1.0.6.RELEASE"
}

group = "club.minnced"
version = "1.0.5"

allprojects {
    repositories {
        jcenter()
    }

    apply(plugin="java-library")
    apply(plugin="maven-publish")

    group = "club.minnced"
}

dependencyManagement {
    dependencies {
        dependency("$group:$name-api:$version")
        dependency("$group:$name-natives:$version")
    }
}

val sourcesJar = task<Jar>("sourcesJar") {
    classifier = "sources"
}

val bintrayUpload: Task by tasks
val build: Task by tasks
build.dependsOn(sourcesJar)

bintrayUpload.apply {
    dependsOn(build)
}

bintray {
    dryRun = false
    override = false
    user = properties["bintrayUsername"] as String
    key = properties["bintrayApiKey"] as String
    setPublications("BintrayRelease")
    pkg(delegateClosureOf<BintrayExtension.PackageConfig> {
        repo = "maven"
        name = project.name + "-bom"
        setLicenses("Apache-2.0")
        vcsUrl = "https://github.com/discord-java/opus-java.git"
        githubRepo = "discord-java/opus-java"
        publish = true
        version(delegateClosureOf<BintrayExtension.VersionConfig> {
            name = project.version.toString()
            vcsTag = name
            gpg.isSign = true
        })
    })
}

publishing {
    publications {
        register<MavenPublication>("BintrayRelease") {
            groupId = project.group as String
            artifactId = project.name + "-bom"
            version = version
        }
    }
}
