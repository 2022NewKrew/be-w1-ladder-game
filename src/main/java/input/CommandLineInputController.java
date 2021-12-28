package input;

import dto.LadderInputInfo;

import java.util.Scanner;

import static validator.Validator.*;

public class CommandLineInputController implements InputController {

    @Override
    public LadderInputInfo createLadderInfo() {
        try (Scanner sc = new Scanner(System.in)) {
            int numberOfParticipants = typeParticipants(sc);
            int heights = typeHeights(sc);
            return new LadderInputInfo(numberOfParticipants, heights);
        }
    }

    public int typeParticipants(Scanner sc) {
        try {
            System.out.println("참여할 사람은 몇 명인가요?");
            int numberOfParticipants = sc.nextInt();
            checkPositiveInteger(numberOfParticipants);
            return numberOfParticipants;
        } catch (IllegalArgumentException e) {
            System.out.println("양의 정수를 입력해주세요");
            return typeParticipants(sc);
        }
    }

    public int typeHeights(Scanner sc) {
        try {
            System.out.println("최대 사다리 높이는 몇 개인가요?");
            int heights = sc.nextInt();
            checkPositiveInteger(heights);
            return heights;
        } catch (IllegalArgumentException e) {
            System.out.println("양의 정수를 입력해주세요");
            return typeHeights(sc);
        }
    }
}
