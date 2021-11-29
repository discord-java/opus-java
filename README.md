[api-version]: https://img.shields.io/maven-central/v/club.minnced/opus-java-api
[api-download]: https://mvnrepository.com/artifact/club.minnced/opus-java-api/latest
[natives-version]: https://img.shields.io/maven-central/v/club.minnced/opus-java-natives
[natives-download]: https://mvnrepository.com/artifact/club.minnced/opus-java-natives/latest
[core-version]: https://img.shields.io/maven-central/v/club.minnced/opus-java
[core-download]: https://mvnrepository.com/artifact/club.minnced/opus-java/latest

# opus-java

Modular java binding for opus natives.

## Artifacts

All artifacts are published to **maven central**.

**Gradle**

```gradle
repositories {
    mavenCentral()
}
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
    implementation("club.minnced:opus-java-api:%VERSION%")
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
    implementation("club.minnced:opus-java-natives:%VERSION%")
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

**Gradle**

```gradle
dependencies {
    implementation("club.minnced:opus-java:%VERSION%")
}
```

**Maven**

```xml
<dependency>
    <groupId>club.minnced</groupId>
    <artifactId>opus-java</artifactId>
    <version>%VERSION%</version>
</dependency>
```
