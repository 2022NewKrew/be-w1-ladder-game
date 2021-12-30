package controller.scanner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringArrayScanner implements BaseScanner<ArrayList<String>> {
    private final String DELIMITER = ",";
    private int maxLength = 5;

    @Override
    public ArrayList<String> parse(String s) {
        return listToArrayList(s.split(DELIMITER));
    }

    private ArrayList<String> listToArrayList(String[] list) {
        List<String> stringList = Arrays.asList(list);
        return new ArrayList<String>(stringList);
    }

    @Override
    public void validate(ArrayList<String> value) {
        for (String s : value) {
            validateNullString(s);
            validateEmptyString(s);
            validateLimitLengthString(s);
        }
    }

    private void validateNullString(String s) {
        if (s == null) {
            throw new TypeScannerException("문자열이 null입니다.");
        }
    }

    private void validateEmptyString(String s) {
        if (s.isEmpty()) {
            throw new TypeScannerException("빈 문자열이 존재합니다.");
        }
    }

    private void validateLimitLengthString(String s) {
        if (s.length() > maxLength) {
            throw new TypeScannerException("문자열의 길이는 " + maxLength + "이하여야 합니다.");
        }
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }
}
