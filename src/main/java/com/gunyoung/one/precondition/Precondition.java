package com.gunyoung.one.precondition;

public class Precondition {

    private Precondition() {
    }

    public static <T> T notNull(T object, String message) throws PreconditionViolationException {
        condition(object != null, message);
        return object;
    }

    public static int notLessThanInt(int object, int another, String message) throws PreconditionViolationException {
        condition(Integer.compare(object, another) >= 0, message);
        return object;
    }

    private static void condition(boolean predicate, String message) {
        if (!predicate)
            throw new PreconditionViolationException(message);
    }
}
