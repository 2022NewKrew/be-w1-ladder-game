import java.util.ArrayList;
import java.util.Random;

//사다리의 하나의 층을 담당하는 클래스
public class Line {

    //상수 및 클래스 변수
    //인스턴스 변수
    private final ArrayList<Character> line = new ArrayList<>();

    //메서드
    //getter, 현재 미사용, 추후 게임 결과 판단할 때 사용될 예정
    public ArrayList<Character> getLine() {
        return line;
    }

    //setter
    public void setLine(int players, char[] CHARSET) {
        for (int i = 0; i < players - 1; i++) {
            line.add(CHARSET[randomInt()]);
        }
    }

    //라인 포맷 변경 후 출력
    public void printLine() {
        for (Character c : line) {
            System.out.print("|" + c);
        }
        System.out.println('|');
    }

    //random int 생성
    private int randomInt() {
        Random rand = new Random();
        return rand.nextInt(2);
    }
}
