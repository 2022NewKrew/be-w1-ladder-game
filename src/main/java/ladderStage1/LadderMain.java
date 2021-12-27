package ladderStage1;

import java.util.Scanner;

public class LadderMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int manCnt, maxHeight;

        System.out.println("참여할 사람은 몇 명인가요?");
        manCnt = sc.nextInt();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        maxHeight = sc.nextInt();

        Ladder ladder = new Ladder(manCnt, maxHeight);
        ladder.make();
        ladder.print();
    }
}
