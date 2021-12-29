package stepone;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LadderStepThree {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        List<String> players = Arrays.asList(scanner.next().split(","));
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int ladderHeight = scanner.nextInt();
        scanner.close();

        Ladder ladder = new Ladder(ladderHeight, players);
        System.out.println("실행결과");
        ladder.printLadder();
    }
}
