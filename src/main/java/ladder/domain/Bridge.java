package ladder.domain;

//사다리의 각 케이스 정의
public class Bridge {
    private Boolean bridge; //브릿지
    private static final Boolean EXIST = true;
    private static final Boolean EMPTY = false;

    public Bridge() {
        this.bridge = EMPTY;
    }

    // 브릿지 생성
    public void drawBridge() {
        this.bridge = EXIST;
    }

    //브릿지 존재 여부 검사
    public boolean isExist() {
        if (bridge == EXIST) {
            return true;
        }
        return false;
    }

}
