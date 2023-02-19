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
public class LimitModel {
    long bytes;
}
