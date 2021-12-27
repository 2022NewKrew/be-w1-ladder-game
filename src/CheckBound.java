public class CheckBound {
    public static int checkIntBound(
            final int val,
            final int min,
            final int max
    ) {
      return Math.max(min, Math.min(val, max));
    }
}
