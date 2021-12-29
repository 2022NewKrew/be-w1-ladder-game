package ladder;

import java.util.Scanner;

public class LadderGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("참여할 사람은 몇 명인가요?");
        int participants = sc.nextInt();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = sc.nextInt();

        BridgeBuilder bridgeBuilder = new BridgeBuilder(participants, height, new RandomBridgeManger(System.currentTimeMillis()));
        Ladder ladder = new Ladder(participants, height, bridgeBuilder.build());
        LadderRenderer.render(ladder);
    }

}
