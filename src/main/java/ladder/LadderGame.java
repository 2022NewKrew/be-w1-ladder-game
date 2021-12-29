package ladder;

import java.util.Scanner;

public class LadderGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String[] participants = sc.next().split(",");
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = sc.nextInt();

        BridgeBuilder bridgeBuilder = new BridgeBuilder(participants, height, new RandomBridgeManger(System.currentTimeMillis()));
        Ladder ladder = new Ladder(participants, height, bridgeBuilder.build());
        LadderRenderer.render(ladder);
    }

}
