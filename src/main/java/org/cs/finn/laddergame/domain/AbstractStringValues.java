package org.cs.finn.laddergame.domain;

import org.cs.finn.laddergame.util.Checker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class AbstractStringValues<T extends AbstractStringValue> {
    private final List<T> list;

    public AbstractStringValues(final String[] values, final int init, final int min, final int max)
            throws IllegalArgumentException
    {
        Checker.checkIntMinMaxInit(init, min, max);
        if (values == null || values.length == 0) {
            throw new RuntimeException("String array is null or empty!");
        }
        this.list = build(values, min, max);
    }

    public void adjustListSize(final int size, final T value) {
        if (size <= 0) {
            throw new RuntimeException("size is not positive integer! - " + size);
        }
        if (value == null) {
            throw new RuntimeException("value is null!");
        }

        for (int i = list.size(); i < size; i++) {
            list.add(value);
        }
        if (list.size() > size) {
            list.subList(size, list.size()).clear();
        }
    }

    private List<T> build(final String[] values, final int min, final int max) {
        final List<T> valueList = getFilteredList(values, max);
        if (valueList.size() < min || valueList.size() > max) {
            throw new IllegalArgumentException("Valid value count is less then " + min + " or greater then " + max);
        }

        return valueList;
    }

    private List<T> getFilteredList(final String[] values, final int limit) {
        final List<T> list = new ArrayList<>();
        for (String value : values) {
            addOnlyValidValue(list, value, limit);
        }

        return list;
    }

    private void addOnlyValidValue(final List<T> list, final String value, final int limit) {
        if (list.size() > limit) {
            return;
        }
        T t;
        try {
            t = generateValue(value);
        } catch (IllegalArgumentException e) {
            return;
        }

        if (!list.contains(t)) {
            list.add(generateValue(value));
        }
    }

    public abstract T generateValue(final String value);

    public abstract T getNoneValue();

    public static String getDefaultGenerator(final List<? extends AbstractStringValue> defaultValuesList, final String separator) {
        if (defaultValuesList == null || defaultValuesList.isEmpty()) {
            throw new RuntimeException("defaultValuesList is null or empty!");
        }
        if (separator == null || separator.isBlank()) {
            throw new RuntimeException("separator String is null or blank!");
        }

        String[] arr = Arrays.stream(defaultValuesList.toArray(new AbstractStringValue[0]))
                .map(AbstractStringValue::toString)
                .toArray(String[]::new);

        return String.join(separator, arr);
    }

    public List<T> getList() {
        return Collections.unmodifiableList(list);
    }

    public T get(final int idx) {
        if (idx < 0 || idx >= list.size()) {
            throw new IndexOutOfBoundsException("idx is out of [0, (list size) - 1]!");
        }
        return list.get(idx);
    }

    public T find(final String value) {
        if (value == null) {
            throw new RuntimeException("value String is null!");
        }

        T t;
        try {
            t = generateValue(value);
        } catch (IllegalArgumentException e) {
            return getNoneValue();
        }

        final int idx = list.indexOf(t);
        if (idx != -1) {
            return list.get(idx);
        }

        return getNoneValue();
    }
}
