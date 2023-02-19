package net.suuft.shadowsocks;

import lombok.NonNull;
import lombok.experimental.UtilityClass;
import net.suuft.shadowsocks.implementation.RealShadowsocksWrapper;

@UtilityClass
public class ShadowsocksFactory {

    public ShadowsocksWrapper createWrapper(@NonNull String apiAddress) {
        return new RealShadowsocksWrapper(apiAddress);
    }
}
