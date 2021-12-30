package step2LadderGame.util;

import step2LadderGame.exception.CustomFormatException;
import step2LadderGame.exception.NotEqualSizeException;

import java.util.Arrays;
import java.util.List;

public class TypeConverter {
    public static int strToInteger(String str) {
        try {
            final int result = Integer.parseInt(str);
            Validator.isPositive(result);
            return result;
        } catch (NumberFormatException ex) {
            throw new CustomFormatException("잘못된 타입입니다. 양의 정수를 입력해주세요");
        }
    }

    public static List<String> strToStringList(String str) throws CustomFormatException {
        final List<String> strList = Arrays.stream(str.split(","))
                .toList();

        strList.forEach(Validator::isLessThan5length);
        return strList;
    }

    public static class Validator {
        public static void isPositive(int value) {
            if (value < 1)
                throw new NumberFormatException();
        }

        public static void isLessThan5length(String value) {
            if (value.length() > 5)
                throw new CustomFormatException("이름은 5글자 이내로 작성해주세요");
        }
    }
}
