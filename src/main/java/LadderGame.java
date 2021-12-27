import java.util.Scanner;

public class LadderGame {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("참여할 사람은 몇 명인가요?");
        int people = Integer.valueOf(in.nextLine());

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int heightLadder = Integer.valueOf(in.nextLine());

        Ladder ladder = new Ladder(people, heightLadder);
        System.out.println(ladder);
    }
}
