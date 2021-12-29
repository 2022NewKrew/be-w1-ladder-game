import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        LadderGame game = null;
        try { // 사다리 게임에 참여할 사람의 수와 사다리 높이를 시스템에서 입력 받기
            int numberOfParticipant = inputNumberOfParticipant();
            int height = inputLadderHeight();
            game = new LadderGame(numberOfParticipant, height);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return;
        }
        System.out.println(game.getLadderStatus());
    }

    /**
     * 사다리 게임에 참여할 사람의 수 입력 받기
     */
    private static int inputNumberOfParticipant() throws Exception {
        System.out.println("참여할 사람은 몇 명인가요?");
        return inputPositiveNumber();
    }

    /**
     * 사다리 높이 입력 받기
     */
    private static int inputLadderHeight() throws Exception {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return inputPositiveNumber();
    }

    /**
     * 양수 입력 받기
     */
    private static int inputPositiveNumber() throws Exception {
        int number = 0;
        try {
            number = scanner.nextInt();
        } catch (Exception e) {
            throw new Exception("잘못된 입력 값입니다.");
        }
        if (number <= 0) {
            throw new Exception("0과 같거나 작은 수를 입력하였습니다.");
        }
        return number;
    }
}
