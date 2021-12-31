package org.cs.finn.laddergame.util;

import java.util.Arrays;

public class Separator {
    public static final String DEFAULT_SEPARATOR = ",";

    private Separator() {}

    public static String[] splitString(final String str) {
        return splitString(str, DEFAULT_SEPARATOR);
    }

    public static String[] splitString(final String str, final String regex) {
        if (str == null) {
            throw new RuntimeException("str String is null!");
        }
        if (regex == null) {
            throw new RuntimeException("regex String is null!");
        }
        return Arrays.stream(str.split(regex))
                .map(String::trim)
                .toArray(String[]::new);
    }
}
