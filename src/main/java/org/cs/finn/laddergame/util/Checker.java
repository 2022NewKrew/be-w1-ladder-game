package org.cs.finn.laddergame.util;

public class Checker {

    private Checker() {}

    public static void checkIntBound (
            final int val,
            final int min,
            final int max
    ) throws IndexOutOfBoundsException
    {
      if (val != Math.max(min, Math.min(val, max))) {
          throw new IndexOutOfBoundsException(val + " is out of [" + min + ", " + max + "]");
      }
    }

    public static void checkIntMinMaxInit (
            final int init,
            final int min,
            final int max
    ) throws IndexOutOfBoundsException
    {
        if (min > max) {
            throw new IllegalStateException("min value(" + min + ") is greater then max value(" + max + ")");
        }
        if (init != Math.max(min, Math.min(init, max))) {
            throw new IllegalStateException("init value(" + init + ") is out of bound [" + min + ", " + max + "]");
        }
    }
}
