## | `Shadowsocks (Outline VPN) api wrapper`
*You can found full example-code in:* [LINK](https://github.com/suuft/shadowsocks-java-wrapper/blob/master/src/test/java/net/suuft/shadowsocks)

First initialize the instance of ShadowSocks Wrapper:
```java
ShadowsocksWrapper shadowsocks = ShadowsocksFactory
        .createWrapper(API_URL);
```

Cool! Now you can work with the outline api, for example, create a key, and output a link to the console:

```java
int newKeyId = shadowsocks.generateKey().id;
System.out.println("new key: " + newKeyId);
```

Okay, just check it out.