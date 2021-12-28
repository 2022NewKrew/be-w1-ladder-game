package step2.util;

import step2.exception.CustomNumberFormatException;

public class TypeConverter {
    public static int strToInteger(String str) {
        try {
            int result = Integer.parseInt(str);
            Validator.isPositive(result);
            return result;
        } catch (NumberFormatException ex) {
            throw new CustomNumberFormatException();
        }
    }

    public static class Validator {
        public static void isPositive(int value) {
            if (value < 1)
                throw new NumberFormatException();
        }
    }
}
