[api-version]: https://api.bintray.com/packages/minndevelopment/maven/opus-java-api/images/download.svg
[api-download]: https://bintray.com/minndevelopment/maven/opus-java-api/_latestVersion
[natives-version]: https://api.bintray.com/packages/minndevelopment/maven/opus-java-natives/images/download.svg
[natives-download]: https://bintray.com/minndevelopment/maven/opus-java-natives/_latestVersion
[core-version]: https://api.bintray.com/packages/minndevelopment/maven/opus-java-bom/images/download.svg
[core-download]: https://bintray.com/minndevelopment/maven/opus-java-bom/_latestVersion

# opus-java

Modular java binding for opus natives.

## Artifacts

All artifacts are published to **jcenter**.

**Gradle**

```gradle
repositories {
    jcenter()
}
```

**Maven**

```xml
<repository>
    <id>jcenter</id>
    <name>bintray-jcenter</name>
    <url>https://jcenter.bintray.com</url>
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

### opus-java-bom

[ ![version-image][core-version] ][core-download]

Note: Replace `%VERSION%` with the version above.

This artifact depends on **api** and **natives** while not providing
any other features. This can be used if you want all features of this binding.

**Gradle**

```gradle
dependencies {
    compile ("club.minnced:opus-java-bom:%VERSION%")
    compile ("club.minnced:opus-java-api")
    compile ("club.minnced:opus-java-natives")
}
```

**Maven**

```xml
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>club.minnced</groupId>
            <artifactId>opus-java-bom</artifactId>
            <version>%VERSION%</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>
<dependencies>
    <dependency>
        <groupId>club.minnced</groupId>
        <artifactId>opus-java-api</artifactId>
    </dependency>
    <dependency>    
        <groupId>club.minnced</groupId>
        <artifactId>opus-java-natives</artifactId>
    </dependency>
</dependencies>

```
