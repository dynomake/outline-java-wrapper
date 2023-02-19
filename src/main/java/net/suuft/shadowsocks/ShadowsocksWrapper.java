package net.suuft.shadowsocks;

import net.suuft.shadowsocks.model.OutlineKey;
import net.suuft.shadowsocks.model.OutlineKeyList;
import net.suuft.shadowsocks.model.OutlineServer;

/**
 * Shadowsocks Java Wrapper written by suuft developer.
 * Distributed by MIT License.
 */
public interface ShadowsocksWrapper {

    OutlineKeyList getKeys();

    OutlineKey generateKey();

    boolean removeKey(int keyIdentifier);

    OutlineServer getServerInformation();

}
