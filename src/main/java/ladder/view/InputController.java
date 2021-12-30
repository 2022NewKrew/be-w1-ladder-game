package ladder.view;

import ladder.service.LadderService;
import ladder.view.dto.CommandDto;
import ladder.view.dto.LadderDto;

import java.util.Scanner;

public class InputController {
    private static final Scanner sc = new Scanner(System.in);

    public static LadderDto getConfigs() {

        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String inputParticipants = sc.nextLine();
        System.out.println("최대 사다리 높이는 얼마인가요?");
        int height = Integer.parseInt(sc.nextLine());
        System.out.println("실행 결과를 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String resultList = sc.nextLine();

        return new LadderDto(inputParticipants, height, resultList);

    }

    public static CommandDto getCommand() {
        System.out.println("결과를 보고 싶은 사람은?");
        String command = sc.nextLine();
        if (command.equals("춘식이")) sc.close();
        return new CommandDto(command);

    }

}
