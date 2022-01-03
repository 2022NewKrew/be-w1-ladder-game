package org.cs.finn.laddergame.util;

public class Checker {

    private Checker() {}

    public static void checkIntBound (
            final int val,
            final int min,
            final int max
    ) throws IndexOutOfBoundsException
    {
        if (val < 0 || min < 0 || max < 0) {
            throw new IllegalStateException("val or min or max is not 0 or positive integer! - [" + val + ", " + min + ", " + max + "]");
        }
        if (val != Math.max(min, Math.min(val, max))) {
            throw new IndexOutOfBoundsException(val + " is out of [" + min + ", " + max + "]");
        }
    }

    public static void checkIntMinMaxInit (
            final int init,
            final int min,
            final int max
    ) throws IllegalStateException
    {
        if (init < 0 || min < 0 || max < 0) {
            throw new IllegalStateException("init or min or max is not 0 or positive integer! - [" + init + ", " + min + ", " + max + "]");
        }
        if (min > max) {
            throw new IllegalStateException("min value(" + min + ") is greater then max value(" + max + ")");
        }
        if (init != Math.max(min, Math.min(init, max))) {
            throw new IllegalStateException("init value(" + init + ") is out of bound [" + min + ", " + max + "]");
        }
    }
}
