package view;

import dto.LadderInputInfo;
import ladder.domain.LadderConfig;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);
    private static int maxNameLen = LadderConfig.MAX_NAME_LEN.getValue();

    /**
     * << 이름 글자수 제한 5글자 >>
     * 1. 클라이언트가 알아서 5글자 넘지 않게 입력
     * 2. 받고나서 5글자 넘으면 자르기 ✔
     * 3. 5글자 넘으면 Exception
     **/
    public static LadderInputInfo inputLadderInfo() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        List<String> participants = inputParticipantsName();
        System.out.println();

        System.out.println("최대 사다리 높이는 몇인가요?");
        int maxHeightOfLadder = inputHeight();

        return new LadderInputInfo(participants.size(), maxHeightOfLadder, participants);
    }

    public static List<String> inputParticipantsName() {
        String beforeParsing = scanner.nextLine();
        return Arrays.asList(beforeParsing.split(","))
                .stream().map(name -> name.length() > maxNameLen ? name.substring(0, maxNameLen) : name)
                .collect(Collectors.toList());
    }

    public static int inputHeight() {
        int height = scanner.nextInt();
        if (height < 1) throw new IllegalArgumentException("높이는 1 이상입니다.");
        return height;
    }
}
