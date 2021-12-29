package ladder.domain;

import java.util.ArrayList;

public class LadderGenerator {
    // 기본 2차원 사다리 생성
    private static ArrayList<ArrayList> ladderGame = new ArrayList<ArrayList>();

    // line 추가
    public static void AddLine(LineGenerator line) {
        ladderGame.add(line.getLine());
    }

    // 출력
    public static ArrayList<ArrayList> getLadderGame() {
        for (int i = 0; i < ladderGame.size(); i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(ladderGame.get(i).get(j));
            }
            System.out.println();
        }
        return ladderGame;
    }
}
