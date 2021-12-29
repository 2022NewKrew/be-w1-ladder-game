import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static int MAX_NAME_LENGTH = 5;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] participants = inputParticipants(scan);
        int ladderHeight = inputLadderHeight(scan);

        LadderGame game = new LadderGame(new ArrayList<>(Arrays.asList(participants)), new Ladder(participants.length, ladderHeight), new StandardOutDisplayLadder());
        game.displayLadder();
    }

    public static String[] inputParticipants(Scanner scan) {
        try {
            System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요");
            String[] participants = scan.nextLine().split(",");

            if (Arrays.stream(participants).findAny().isEmpty() ||
                   Arrays.stream(participants).anyMatch(s -> s.length() > MAX_NAME_LENGTH)) {
                throw new InputMismatchException();
            }

            return participants;
        } catch (InputMismatchException e) {
            System.out.println("잘못 입력하셨습니다!");
            System.out.println("이름은 " + MAX_NAME_LENGTH + "자 이하여야 합니다.\n");

            return inputParticipants(scan);
        }
    }

    public static int inputLadderHeight(Scanner scan) {
        try {
            System.out.println("최대 사다리 높이는 몇 개 인가요?");
            int height = scan.nextInt();

            if(height <= 0) {
                throw new InputMismatchException();
            }

            return height;
        } catch (InputMismatchException e) {
            System.out.println("잘못 입력하셨습니다!");
            System.out.println("양의 정수만 입력해주세요\n");
            scan.nextLine();

            return inputLadderHeight(scan);
        }
    }
}
