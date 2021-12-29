package ladder;

import java.util.Scanner;

public class LadderMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String[] people = sc.next().split(",");

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int ladderHeight = sc.nextInt();

        Ladder.of(people, ladderHeight).draw();
    }
}
