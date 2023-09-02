package me.dynomake.outline;

public class LittleTest {
    public static void main(String[] args) {
        OutlineWrapper outlineWrapper = OutlineWrapper.create("https://127.0.0.1:50912/api");

        System.out.println("server: " + outlineWrapper.getServerInformation().name);
        System.out.println("in server keys: " + outlineWrapper.getKeys().accessKeys.size());
        int newKeyId = outlineWrapper.generateKey().id;
        System.out.println("new key: " + newKeyId);
        System.out.println("new key delete result: " + outlineWrapper.removeKey(newKeyId));

    }
}
