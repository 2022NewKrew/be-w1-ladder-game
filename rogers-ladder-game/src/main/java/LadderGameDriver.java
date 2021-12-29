import factory.LadderFactory;
import ladder.Ladder;

import java.util.Scanner;

public class LadderGameDriver {
    private static int numberOfPeople;
    private static int ladderHeight;

    public static void main(String[] args) {
        input();
        Ladder ladder = LadderFactory.getInstance(numberOfPeople, ladderHeight);
        System.out.println(ladder);
    }

    private static void input(){
        try(Scanner sc = new Scanner(System.in)){
            System.out.println("참여할 사람은 몇 명인가요?");
            numberOfPeople = sc.nextInt();

            System.out.println("최대 사다리 높이는 몇인가요?");
            ladderHeight = sc.nextInt();
        }
    }
}
