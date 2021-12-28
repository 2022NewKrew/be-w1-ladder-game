import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //입력 부 변경?
        Scanner scan = new Scanner(System.in);

        System.out.println("참여할 사람은 몇 명인가요?");
        int numberOfParticipants = scan.nextInt();

        System.out.println("최대 사다리 높이는 몇 개 인가요?");
        int ladderHeight = scan.nextInt();

        LadderGame game = new LadderGame(numberOfParticipants, ladderHeight);
        game.displayLadder();
    }
}
