package ladder;

import ladder.domain.LadderGenerator;
import ladder.domain.LineGenerator;
import ladder.view.Input;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // 입력(view package 메서드 사용)
        int n = Input.PlayersNum();
        int m = Input.MaximumLadderHeight();


        // 사다리 그리기
        for (int i = 0; i < m; i++) {
            ArrayList<String> temp = LineGenerator.MakeLine(n);
            LineGenerator line = new LineGenerator(temp);
            LadderGenerator.AddLine(line);
        }

        // 출력
        LadderGenerator.getLadderGame();
    }
}