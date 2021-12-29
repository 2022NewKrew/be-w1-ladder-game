import domain.Ladder;
import factory.LadderFactory;

import java.util.List;
import java.util.Scanner;

public class LadderGameDriver {
    private static List<String> names;
    private static int ladderHeight;

    public static void main(String[] args) {
        input();
        Ladder ladder = LadderFactory.getInstance(names, ladderHeight);
        System.out.println(ladder);
    }

    private static void input(){
        try(Scanner scanner = new Scanner(System.in)){
            System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
            names = List.of(scanner.nextLine().split(","));

            System.out.println("최대 사다리 높이는 몇인가요?");
            ladderHeight = scanner.nextInt();
        }
    }
}
