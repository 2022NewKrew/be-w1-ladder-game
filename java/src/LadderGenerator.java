import java.util.ArrayList;

//사다리 게임을 위한 사다리 생성 클래스
public class LadderGenerator {

    //상수 및 클래스 변수
    private final char[] CHARSET = {' ', '-'};
    //인스턴스 변수
    private ArrayList<Line> generatedLadder;

    //생성자
    //메서드
    //사다리를 생성하여 generatedLadder 에 저장
    public void generateLadder(int players, int height) {
        generatedLadder = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            Line curLine = new Line();
            curLine.setLine(players, CHARSET);
            generatedLadder.add(curLine);
        }
    }

    //생성된 사다리 generatedLadder 리턴
    public ArrayList<Line> getLadder() {
        if (generatedLadder == null) return null;
        return generatedLadder;
    }
}
