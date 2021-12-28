package ladderStage2;

import java.util.Scanner;

public class LadderApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int participantCount, maxHeight;

        System.out.println("참여할 사람은 몇 명인가요?");
        participantCount = sc.nextInt();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        maxHeight = sc.nextInt();

        Ladder ladder = new Ladder(participantCount, maxHeight);
        ladder.viewResult();
    }
}
