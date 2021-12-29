package input;

import dto.LadderInputInfo;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static validator.Validator.checkPositiveInteger;
import static validator.Validator.checkNameLength;

public class CommandLineInputController implements InputController {
    private static final String commaSeparationRegex = "\\s*,\\s*";

    @Override
    public LadderInputInfo inputLadderInfo() {
        try (Scanner sc = new Scanner(System.in)) {
            List<String> participantsNames = typeParticipants(sc);
            int numberOfParticipants = participantsNames.size();
            int heights = typeHeights(sc);
            return new LadderInputInfo(numberOfParticipants, heights, participantsNames);
        }
    }

    private List<String> typeParticipants(Scanner sc) {
        try {
            System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
            String oneLineParticipantsNames = sc.nextLine();
            List<String> participantsNames = Arrays.asList(oneLineParticipantsNames.split(commaSeparationRegex));
            checkNameLength(participantsNames);
            return participantsNames;
        } catch (IllegalArgumentException e) {
            System.out.println("참여할 사람의 이름은 5글자 이상이어야 합니다.");
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
