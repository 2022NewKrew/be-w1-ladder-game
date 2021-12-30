package com.gunyoung.one.precondition;

public final class Precondition {

    private Precondition() {
    }

    public static <T> T notNull(T object, RuntimeException runtimeException) {
        condition(object != null, runtimeException);
        return object;
    }

    public static String notEmpty(String object, RuntimeException runtimeException) {
        notNull(object, runtimeException);
        condition(!object.isEmpty(), runtimeException);
        return object;
    }

    public static int notLessThanInt(int object, int another, RuntimeException runtimeException) {
        condition(Integer.compare(object, another) >= 0, runtimeException);
        return object;
    }

    private static void condition(boolean predicate, RuntimeException runtimeException) {
        if (!predicate)
            throw runtimeException;
    }
}
