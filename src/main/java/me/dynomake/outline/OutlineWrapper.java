package me.dynomake.outline;

import lombok.NonNull;
import me.dynomake.outline.implementation.RealOutlineWrapper;
import me.dynomake.outline.model.OutlineKey;
import me.dynomake.outline.model.OutlineKeyList;
import me.dynomake.outline.model.OutlineServer;

/**
 * Outline Java Wrapper written by dynomake developer.
 * Distributed by MIT License.
 */
public interface OutlineWrapper {

    static OutlineWrapper create(@NonNull String apiAddress) {
        return new RealOutlineWrapper(apiAddress);
    }

    OutlineKeyList getKeys();

    OutlineKey generateKey();
    OutlineKey getKey(int keyIdentifier);
    void renameKey(int keyIdentifier, @NonNull String name);
    boolean removeKey(int keyIdentifier);
    OutlineServer getServerInformation();

}
