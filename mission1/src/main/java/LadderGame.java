import java.util.Scanner;

public class LadderGame {
    public static void main(String[] args) {
        System.out.println("사다리 게임을 시작합니다.");
        Scanner scanner = new Scanner(System.in);

        System.out.println("참여할 사람은 몇 명인가요?");
        int numOfPlayer = Integer.parseInt(scanner.nextLine());

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int maxHeight = Integer.parseInt(scanner.nextLine());

        LadderGamePlayer player = new LadderGamePlayer(maxHeight, numOfPlayer);
        player.play();
    }
}