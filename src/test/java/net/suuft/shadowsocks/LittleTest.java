package net.suuft.shadowsocks;

public class LittleTest {
    public static void main(String[] args) {
        ShadowsocksWrapper shadowsocks = ShadowsocksFactory
                .createWrapper("https://127.0.0.1:50912/api");

        System.out.println("server: " + shadowsocks.getServerInformation().name);
        System.out.println("in server keys: " + shadowsocks.getKeys().accessKeys.size());
        int newKeyId = shadowsocks.generateKey().id;
        System.out.println("new key: " + newKeyId);
        System.out.println("new key delete result: " + shadowsocks.removeKey(newKeyId));

    }
}
