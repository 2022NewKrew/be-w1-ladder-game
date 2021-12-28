import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LadderGame {
    int width;
    int height;
    List<StringBuilder> ladder = new ArrayList<>();
    private final int LADDER = 124;
    private final int CONNECTION = 45;
    private final int SPACE = 32;

    LadderGame() {
        Scanner sc = new Scanner(System.in);
        System.out.println("참여할 사람은 몇 명인가요?");
        int people = sc.nextInt();
        width = 2 * people - 1;
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        height = sc.nextInt();
    }

    public void makeLadder() {
        for (int r = 0; r < height; r++) {
            ladder.add(singleRow());
        }
    }

    public void printLadder() {
        for (int r = 0; r < height; r++) {
            System.out.println(ladder.get(r));
        }
    }

    // else 문을 제거하기 위해선 if ~ 후 return하는 방법도 있지만, 문자 고유의 아스키코드가 있다는 점에 착안했습니다.
    // 변화하는 c값(column값)에 따라 적절한 아스키코드값을 가질 수 있다면, if문을 아예 쓰지 않아도 되리라 판단하고 메서드를 작성했습니다.
    private char ladderElement(int column) {
        // elemet의 값은 세로로 이어진 사다리 LADDER로 초기화
        int element = LADDER;
        // 0 또는 1의 값을 갖는 랜덤 숫자
        int randomNumber = (int) (Math.random() * 2);
        // 랜덤 숫자에 따라 CONNECTION 인지, SPACE 인지를 결정할 숫자
        int isConnection = (CONNECTION - SPACE) * randomNumber;
        // CONNECTION인지 SPACE인지 결정한 후, LADDER 값과의 차이를 보정
        isConnection += LADDER - CONNECTION;
        // 만약 column이 짝수라면 0, 홀수라면 isConnection 이 되는 값
        int isLadder = (column % 2) * isConnection;
        // 기존 element(=LADDER)에서 값을 빼주어 적절한 element ascii값을 얻음
        element -= isLadder;
        return (char) element;
    }

    private StringBuilder singleRow() {
        StringBuilder row = new StringBuilder();
        for (int c = 0; c < width; c++) {
            row.append(ladderElement(c));
        }
        return row;
    }


}
