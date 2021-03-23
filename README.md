[api-version]: https://shields.io/maven-metadata/v?metadataUrl=https%3A%2F%2Fm2.dv8tion.net%2Freleases%2Fclub%2Fminnced%2Fopus-java-api%2Fmaven-metadata.xml&color=informational&label=Download
[api-download]: #opus-java-api
[natives-version]: https://shields.io/maven-metadata/v?metadataUrl=https%3A%2F%2Fm2.dv8tion.net%2Freleases%2Fclub%2Fminnced%2Fopus-java-natives%2Fmaven-metadata.xml&color=informational&label=Download
[natives-download]: #opus-java-natives
[core-version]: https://shields.io/maven-metadata/v?metadataUrl=https%3A%2F%2Fm2.dv8tion.net%2Freleases%2Fclub%2Fminnced%2Fopus-java%2Fmaven-metadata.xml&color=informational&label=Download
[core-download]: #opus-java

# opus-java

Modular java binding for opus natives.

## Artifacts

All artifacts are published to an **S3 Bucket**.

**Gradle**

```gradle
repositories {
    maven {
        name = "m2-dv8tion"
        url = "https://m2.dv8tion.net/releases"
    }
}
```

**Maven**

```xml
<repository>
    <id>dv8tion</id>
    <name>m2-dv8tion</name>
    <url>https://m2.dv8tion.net/releases</url>
</repository>
```

### opus-java-api

[ ![version-image][api-version] ][api-download]

Note: Replace `%VERSION%` with the version above.

This artifact only provides the interface to access the native opus libraries. 
It can be used without `opus-java-natives` by providing the library to `OpusLibrary.loadFrom(String)` using
an absolute path.

**Gradle**

```gradle
dependencies {
    compile 'club.minnced:opus-java-api:%VERSION%'
}
```

**Maven**

```xml
<dependency>
    <groupId>club.minnced</groupId>
    <artifactId>opus-java-api</artifactId>
    <version>%VERSION%</version>
</dependency>
```

### opus-java-natives

[ ![version-image][natives-version] ][natives-download]

Note: Replace `%VERSION%` with the version above.

This artifact only provides the native opus libraries as resources.
<br>The libraries are located under `/natives` and can be loaded at runtime.

**Gradle**

```gradle
dependencies {
    compile 'club.minnced:opus-java-natives:%VERSION%'
}
```

**Maven**

```xml
<dependency>
    <groupId>club.minnced</groupId>
    <artifactId>opus-java-natives</artifactId>
    <version>%VERSION%</version>
</dependency>
```

### opus-java

[ ![version-image][core-version] ][core-download]

Note: Replace `%VERSION%` with the version above.

This artifact depends on **api** and **natives** while not providing
any other features. This can be used if you want all features of this binding.
<br>Note that this is of type `pom` rather than the default `jar`.

**Gradle**

```gradle
dependencies {
    compile ('club.minnced:opus-java:%VERSION%@pom') {
        transitive = true // gradle defaults to transitive false with @pom
    }
}
```

**Maven**

```xml
<dependency>
    <groupId>club.minnced</groupId>
    <artifactId>opus-java</artifactId>
    <version>%VERSION%</version>
    <type>pom</type>
</dependency>
```
