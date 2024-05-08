package me.dynomake.outline.implementation.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * Outline Java Wrapper written by dynomake developer.
 * Distributed by MIT License.
 */
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
public class Response {
    int responseCode;
    String responseString;
}
