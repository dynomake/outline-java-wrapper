package net.suuft.shadowsocks.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * Shadowsocks Java Wrapper written by suuft developer.
 * Distributed by MIT License.
 */
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
public class OutlineKey {
    int id;
    String name;
    String password;
    int port;
    String method;
    String accessUrl;
//    int used_bytes;
}
