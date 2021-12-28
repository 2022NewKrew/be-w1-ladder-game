package input;

import dto.LadderInfo;

import java.util.Scanner;

public class CommandLineInputController implements InputController {

    @Override
    public LadderInfo createLadderInfo() {
        try (Scanner sc = new Scanner(System.in)) {
            int numberOfParticipants = typeParticipants(sc);
            int heights = typeHeights(sc);
            return new LadderInfo(numberOfParticipants, heights);
        }
    }

    public int typeParticipants(Scanner sc) {
        try {
            System.out.println("참여할 사람은 몇 명인가요?");
            int numberOfParticipants = sc.nextInt();
            if (numberOfParticipants < 0) {
                throw new NumberFormatException();
            }
            return numberOfParticipants;
        } catch (NumberFormatException e) {
            System.out.println("양의 정수를 입력해주세요");
            return typeParticipants(sc);
        }
    }

    public int typeHeights(Scanner sc) {
        try {
            System.out.println("최대 사다리 높이는 몇 개인가요?");
            int heights = sc.nextInt();
            if (heights < 0) {
                throw new NumberFormatException();
            }
            return heights;
        } catch (NumberFormatException e) {
            System.out.println("양의 정수를 입력해주세요");
            return typeHeights(sc);
        }
    }
}
