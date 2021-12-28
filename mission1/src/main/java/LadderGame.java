import java.util.InputMismatchException;
import java.util.Scanner;

public class LadderGame {
    public static void main(String[] args) {
        System.out.println("사다리 게임을 시작합니다.");

        System.out.println("참여할 사람은 몇 명인가요?");
        int numOfPlayer = getInput();

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int maxHeight = getInput();

        LadderGamePlayer player = new LadderGamePlayer(maxHeight, numOfPlayer);
        player.play();
    }

    static int getInput() {
        Scanner scanner = new Scanner(System.in);

        try {
            int result = scanner.nextInt();
            return checkInput(result) ? result : getInput();
        }
        catch (InputMismatchException e) {
            return getInput();
        }
    }

    static boolean checkInput(int value) {
        if (value > 0)
            return true;
        System.out.println("0보다 큰 정수를 입력해주세요.");
        return false;
    }
}