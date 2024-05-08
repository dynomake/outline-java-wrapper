package me.dynomake.outline.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * Outline Java Wrapper written by dynomake developer.
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
