package ladder;

import ladder.domain.bridge.BridgeBuilder;
import ladder.exception.LadderException;
import ladder.domain.ladder.Ladder;
import ladder.domain.bridge.RandomBridgeProviderImpl;
import ladder.domain.ladder.LadderInfo;
import ladder.domain.ladder.LadderResult;
import ladder.view.LadderRenderer;

import java.util.Scanner;

public class LadderGame {

    private static final String INPUT_DELIMITER = ",";
    private static final String ALL_COMMAND = "all";
    private static final String END_COMMAND = "춘식이";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LadderInfo ladderInfo = getInput(sc);

        BridgeBuilder bridgeBuilder = new BridgeBuilder(ladderInfo, new RandomBridgeProviderImpl(System.currentTimeMillis()));
        Ladder ladder = new Ladder(ladderInfo, bridgeBuilder.build());
        System.out.println(LadderRenderer.render(ladder));

        LadderResult ladderResult = new LadderResult(ladder);
        printResult(sc, ladderResult);
    }

    private static LadderInfo getInput(Scanner sc) {
        LadderInfo ladderInfo;

        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String[] participants = sc.next().split(INPUT_DELIMITER);
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요");
        String[] results = sc.next().split(INPUT_DELIMITER);
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = sc.nextInt();

        try {
            ladderInfo = new LadderInfo(participants, results, height);
        } catch (LadderException e) {
            System.out.println(e.getErrorMessage());
            ladderInfo = getInput(sc);
        }
        return ladderInfo;
    }

    private static void printResult(Scanner sc, LadderResult ladderResult) {
        String command;
        do {
            System.out.println("결과를 보고 싶은 사람은?");
            command = sc.next();
            System.out.println(getResult(command, ladderResult));
        } while (!command.equals(END_COMMAND));
<<<<<<< HEAD
=======
        System.out.println("게임을 종료합니다.");
>>>>>>> e12e8ef1f80c5080d7ace40b8c9a973ef5ee2b56
    }

    private static String getResult(String command, LadderResult ladderResult) {
        if (command.equals(ALL_COMMAND)) {
            return ladderResult.getAllResult();
        }
<<<<<<< HEAD
        if (command.equals(END_COMMAND)) {
            return "게임을 종료합니다.";
        }
=======
>>>>>>> e12e8ef1f80c5080d7ace40b8c9a973ef5ee2b56

        String oneResult = ladderResult.getOneResult(command);
        if (oneResult != null) {
            return oneResult;
        }
<<<<<<< HEAD
        return "입력한 참여자의 정보가 없습니다.";
=======
        return "";
>>>>>>> e12e8ef1f80c5080d7ace40b8c9a973ef5ee2b56
    }

}
