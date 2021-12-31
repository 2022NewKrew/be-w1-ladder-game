package org.cs.finn.laddergame.domain;

import java.util.Objects;

public abstract class AbstractStringValue {
    private final String value;

    public AbstractStringValue(final String value, final int maxLen, final String regex) {
        if (value == null) {
            throw new RuntimeException("value String is null!");
        }
        if (maxLen <= 0) {
            throw new RuntimeException("length is not positive integer!");
        }
        if (regex == null || regex.isBlank()) {
            throw new RuntimeException("regex String is null or blank!");
        }

        validate(value, maxLen, regex);
        this.value = value;
    }

    private static void validate(final String value, final int maxLen, final String regex) {
        if (value.isBlank()) {
            throw new IllegalArgumentException("value String is blank!");
        }
        if (value.length() > maxLen) {
            throw new IllegalArgumentException("value String length is longer than limit " + maxLen + " - " + value);
        }
        if (!value.matches(regex)) {
            throw new IllegalArgumentException("Illegal character found in member String! - " + value);
        }
    }

    @Override
    public String toString() {
        return value;
    }

    // Auto-generated code
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractStringValue that = (AbstractStringValue) o;
        return value.equals(that.value);
    }

    // Auto-generated code
    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
