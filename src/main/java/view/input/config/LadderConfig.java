package view.input.config;

public class LadderConfig {
    // 불변
    private final int peopleCount;
    private final int height;

    public LadderConfig(int peopleCount, int height) {
        this.peopleCount = peopleCount;
        this.height = height;
//        validateInput();
    }

    public int getPeopleCount() {
        return peopleCount;
    }

    public int getHeight() {
        return height;
    }

//    // 입력값을 검증 (음수 여부)
//    private void validateInput() {
//        if (this.peopleCount < 1) throw new IllegalArgumentException("1명 이상의 인원 수를 입력하세요.");
//        if (this.height < 1) throw new IllegalArgumentException("1 이상의 높이를 입력하세요.");
//    }
}
