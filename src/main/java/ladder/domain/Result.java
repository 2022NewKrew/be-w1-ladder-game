package ladder.domain;

import ladder.exception.IllegalPlayerNameException;

public class Result {

    private final String result;

    public Result(String result) {
        this.result = result;
        validateResult();
    }

    private void validateResult() {
        if (result  == null || result.equals("") || result.equals(" ")) {
            throw new IllegalPlayerNameException("결과는 공백일 수 없습니다.");
        }
    }

    public String getResult() {
        return result;
    }

    public int getResultLength() {
        return result.length();
    }

    @Override
    public String toString() {
        return result;
    }
}
