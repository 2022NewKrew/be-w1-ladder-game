import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class LadderGame {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("참여할 사람은 몇 명인가요?");
        int people = sc.nextInt();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int depth = sc.nextInt();

        Ladder ladder = new Ladder(people, depth);
        ladder.randomLine();
        ladder.print();
    }
}
