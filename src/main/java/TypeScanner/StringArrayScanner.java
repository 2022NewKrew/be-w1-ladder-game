package TypeScanner;

public class StringArrayScanner implements BaseScanner<String[]> {
    private String delimiter = ",";
    private int maxLength = 5;

    @Override
    public String[] parse(String s) {
        return s.split(delimiter);
    }

    @Override
    public void validate(String[] value) {
        for (String s : value) {
            validateEmptyString(s);
            validateLimitLengthString(s);
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

    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    public String getDelimiter() {
        return delimiter;
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    public int getMaxLength() {
        return maxLength;
    }
}
