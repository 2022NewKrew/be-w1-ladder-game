package ladder;

import ladder.domain.bridge.BridgeBuilder;
import ladder.domain.exception.LadderException;
import ladder.domain.ladder.Ladder;
import ladder.domain.bridge.RandomBridgeProviderImpl;
import ladder.domain.ladder.LadderInfo;
import ladder.view.LadderRenderer;

import java.util.Scanner;

public class LadderGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LadderInfo ladderInfo = getInput(sc);

        BridgeBuilder bridgeBuilder = new BridgeBuilder(ladderInfo, new RandomBridgeProviderImpl(System.currentTimeMillis()));
        Ladder ladder = new Ladder(ladderInfo, bridgeBuilder.build());
        System.out.println(LadderRenderer.render(ladder));
    }

    private static LadderInfo getInput(Scanner sc) {
        LadderInfo ladderInfo;

        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String[] participants = sc.next().split(",");
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요");
        String[] results = sc.next().split(",");
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

}
