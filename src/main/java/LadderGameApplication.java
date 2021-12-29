import java.util.Scanner;

public class LadderGameApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LadderGame ladderGame = new LadderGame();

        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String nameInputs = scanner.next();

        System.out.println("최대 사다리 높이는 몇인가요?");
        int heightOfLadder = scanner.nextInt();

        ladderGame.run(nameInputs, heightOfLadder);
    }
}
