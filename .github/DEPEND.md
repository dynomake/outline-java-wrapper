## | `Shadowsocks (Outline VPN) api wrapper`
Here is how to add this sdk depending on your project.
### | `Gradle`:
If you use Gradle with Groovy, then here is an example of adding dependencies:
```groovy
repositories {
    // other repositories
    maven {
        name = "clojars.org"
        url = uri("https://repo.clojars.org")
    }
}

dependencies {
    // other depend
    implementation 'works.naifu:shadowsocks-java-wrapper:1.0.0'
}
```

### | `Maven`:

Repository:

```xml
<repository>
    <id>clojars.org</id>
    <url>https://repo.clojars.org</url>
</repository>
```

Depend:

```xml

<dependency>
    <groupId>works.naifu</groupId>
    <artifactId>shadowsocks-java-wrapper</artifactId>
    <version>1.0.0</version>
</dependency>
```