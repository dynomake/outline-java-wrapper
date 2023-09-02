package me.dynomake.outline;

import lombok.NonNull;
import me.dynomake.outline.implementation.RealOutlineWrapper;
import me.dynomake.outline.model.OutlineKey;
import me.dynomake.outline.model.OutlineKeyList;
import me.dynomake.outline.model.OutlineServer;

/**
 * Shadowsocks Java Wrapper written by dynomake developer.
 * Distributed by MIT License.
 */
public interface OutlineWrapper {

    static OutlineWrapper create(@NonNull String apiAddress) {
        return new RealOutlineWrapper(apiAddress);
    }

    OutlineKeyList getKeys();

    OutlineKey generateKey();

    boolean removeKey(int keyIdentifier);

    OutlineServer getServerInformation();

}
