package ladderStage3;

import java.util.Scanner;

public class LadderApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        Participants participants = new Participants(sc.next());

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int maxHeight = sc.nextInt();

        Ladder ladder = new Ladder(participants, maxHeight);
        ladder.viewResult(participants);
    }
}
