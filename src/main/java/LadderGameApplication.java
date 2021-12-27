import java.util.Scanner;

public class LadderGameApplication {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LadderGame ladderGame = new LadderGame();

        System.out.println("참여할 사람은 몇 명인가요?");
        int person = sc.nextInt();

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int ladder = sc.nextInt();

        ladderGame.run(person, ladder);
    }
}
