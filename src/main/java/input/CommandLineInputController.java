package input;

import dto.LadderInputInfo;

import java.util.Scanner;

import static validator.Validator.checkPositiveInteger;

public class CommandLineInputController implements InputController {

    @Override
    public LadderInputInfo inputLadderInfo() {
        try (Scanner sc = new Scanner(System.in)) {
            int numberOfParticipants = typeParticipants(sc);
            int heights = typeHeights(sc);
            return new LadderInputInfo(numberOfParticipants, heights);
        }
    }

    private int typeParticipants(Scanner sc) {
        try {
            System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
            int numberOfParticipants = sc.nextInt();
            checkPositiveInteger(numberOfParticipants);
            return numberOfParticipants;
        } catch (IllegalArgumentException e) {
            System.out.println("양의 정수를 입력해주세요");
            return typeParticipants(sc);
        }
    }

    private int typeHeights(Scanner sc) {
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
