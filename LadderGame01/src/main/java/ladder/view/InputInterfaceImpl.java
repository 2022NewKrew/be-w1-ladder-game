package ladder.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputInterfaceImpl implements InputInterface{

    @Override
    public List<String> inputParticipants(Scanner scanner) {
        List<String> participants;
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String names = scanner.nextLine();
        if(names.length() == 0) return new ArrayList<>();

        participants = Arrays.asList(names.split(","));
        return participants;
    }

    @Override
    public int inputLadderWidth(Scanner scanner) {
        System.out.println("참여할 사람은 몇 명인가요?");
        return scanner.nextInt();
    }

    @Override
    public int inputLadderHeight(Scanner scanner) {
        System.out.println("최대 사다리 높이는 몇 개 인가요?");
        return scanner.nextInt();
    }

}
