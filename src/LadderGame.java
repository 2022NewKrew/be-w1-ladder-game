import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class LadderGame {
    int people;
    int height;
    ArrayList<StringBuilder> ladder = new ArrayList<>();

    LadderGame() {
        Scanner sc = new Scanner(System.in);
        System.out.println("참여할 사람은 몇 명인가요?");
        people = sc.nextInt();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        height = sc.nextInt();
    }

    // 아스키코드를 이용해서 사다리 element를 stringbuilder에 추가한다
    // '|' : 124, ' ' : 32, '-' : 45
    private StringBuilder singleRow() {
        StringBuilder row = new StringBuilder();
        for (int c=0; c<2*people-1; c++) {
            int ascii = 124 - (c%2) * ((int)(Math.random()*2)*13 + 79);
            row.append((char)ascii);
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
