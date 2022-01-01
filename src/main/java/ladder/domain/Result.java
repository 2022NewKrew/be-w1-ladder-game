package ladder.domain;

public class Result {
    private static final int MAX_RESULT_LEN = 5;
    private final String name;

    public Result(String name) {
        validateResultLength(name);
        this.name = name;
    }

    void validateResultLength(String name) {
        if (name.length() > MAX_RESULT_LEN) {
            throw new IllegalArgumentException(String.format("결과의 길이는 %d를 넘을 수 없습니다.", MAX_RESULT_LEN));
        }
    }

    @Override
    public String toString() {
        final String printFormat = "%-" + MAX_RESULT_LEN + "." + MAX_RESULT_LEN + "s ";
        return String.format(printFormat, name);
    }
}
