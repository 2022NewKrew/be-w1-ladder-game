import factory.LadderFactory;
import ladder.Ladder;

import java.util.Scanner;

public class LadderGameDriver {
    private static LadderFactory factory = new LadderFactory();
    private static int people;
    private static int width;

    public static void main(String[] args) {
        input();
        Ladder ladder = factory.getInstance(people, width);
        System.out.println(ladder);
    }

    private static void input(){
        try(Scanner sc = new Scanner(System.in)){
            System.out.println("참여할 사람은 몇 명인가요?");
            people = sc.nextInt();

            System.out.println("최대 사다리 높이는 몇인가요?");
            width = sc.nextInt();
        }
    }
}
