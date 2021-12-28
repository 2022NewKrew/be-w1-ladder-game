package org.cs.finn.laddergame.util;

public class CheckBound {
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
}
