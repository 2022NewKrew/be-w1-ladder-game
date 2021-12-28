import domain.LadderGenerator;
import domain.LineGenerator;
import view.Input;
import view.Output;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // 입력(view package 메서드 사용)
        final int PLAYER_NUM = Input.PlayersNum();
        final int MAXIMUM_LADDER_HEIGHT = Input.MaximumLadderHeight();

        List<LineGenerator> list = new ArrayList<>();

        LineGenerator lineGenerator = new LineGenerator(new ArrayList<>());

        // 사다리 그리기
        for (int i = 0; i < MAXIMUM_LADDER_HEIGHT; i++) {
            List<String> temp = lineGenerator.MakeLine(PLAYER_NUM);
            LineGenerator line = new LineGenerator(temp);
            list.add(line);
        }
        LadderGenerator ladderGenerator = new LadderGenerator(list);

        // 출력
        System.out.println(ladderGenerator.getLadder());
        Output.printLadder(ladderGenerator);
    }
}
