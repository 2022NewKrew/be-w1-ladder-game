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

    public void makeLadder() {
        for (int r=0; r<height; r++) {
            StringBuilder row = new StringBuilder();
            Random random = new Random();
            for (int c=0; c<2*people-1; c++) {
                if (c%2 == 0) {
                    row.append('|');
                }
                else if (random.nextBoolean()) {
                    row.append('-');
                }
                else {
                    row.append(' ');
                }
            }
            ladder.add(row);
        }
    }

    public void printLadder() {
        for (int r=0; r<height; r++) {
            System.out.println(ladder.get(r));
        }
    }
}