## | `Outline Server API wrapper`
*You can found full example-code in:* [LINK](https://github.com/dynomake/outline-java-wrapper/blob/master/src/test/java/me/dynomake/outline)

First initialize the instance of ShadowSocks Wrapper:
```java
OutlineWrapper outlineWrapper = OutlineWrapper.create(API_URL);
```

Cool! Now you can work with the outline api, for example, create a key, and output a link to the console:

```java
int newKeyId = outlineWrapper.generateKey().id;
System.out.println("new key: " + newKeyId);
```

Okay, just check it out.