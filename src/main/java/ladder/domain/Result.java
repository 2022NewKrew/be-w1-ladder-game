package ladder.domain;

public class Result {
    private final String content;
    private static final int MIN_LENGTH_OF_CONTENT = 1;
    private static final int MAX_LENGTH_OF_CONTENT = 5;

    public Result(String content) {
        validate(content);
        this.content = content;
    }

    private void validate(String content) {
        int contentLength = content.length();
        if (contentLength < MIN_LENGTH_OF_CONTENT || contentLength > MAX_LENGTH_OF_CONTENT) {
            throw new IllegalArgumentException("결과의 내용은 1글자 이상, 5글자 이하여야합니다.");
        }
    }

    public String getContent() {
        return content;
    }
}
