package net.suuft.shadowsocks.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

/**
 * Shadowsocks Java Wrapper written by suuft developer.
 * Distributed by MIT License.
 */
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
public class OutlineServer {
    String name;
    UUID serverId;
    boolean metricsEnabled;
    long createdTimestampMs;
    String version;
    LimitModel accessKeyDataLimit;
    int portForNewAccessKeys;
    String hostnameForAccessKeys;
}
