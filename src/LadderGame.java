import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LadderGame {
    int people;
    int height;
    List<StringBuilder> ladder = new ArrayList<>();
    private final int LADDER = 124;
    private final int CONNECTION = 45;
    private final int SPACE = 32;

    LadderGame() {
        Scanner sc = new Scanner(System.in);
        System.out.println("참여할 사람은 몇 명인가요?");
        people = sc.nextInt();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        height = sc.nextInt();
    }

    // else 문을 제거하기 위해선 if ~ 후 return하는 방법도 있지만, 문자 고유의 아스키코드가 있다는 점에 착안했습니다.
    // 변화하는 c값(column값)에 따라 적절한 아스키코드값을 가질 수 있다면, if문을 아예 쓰지 않아도 되리라 판단하고 메서드를 작성했습니다.
    private char ladderElement(int c) {
        int ascii = LADDER - (c%2) * (LADDER - CONNECTION + (CONNECTION-SPACE) * (int)(Math.random()*2));
        return (char)ascii;
    }
    private StringBuilder singleRow() {
        StringBuilder row = new StringBuilder();
        for (int c=0; c<2*people-1; c++) {
            row.append(ladderElement(c));
        }
        return row;
    }

    public void makeLadder() {
        for (int r=0; r<height; r++) {
            ladder.add(singleRow());
        }
    }

    public void printLadder() {
        for (int r=0; r<height; r++) {
            System.out.println(ladder.get(r));
        }
    }
}
