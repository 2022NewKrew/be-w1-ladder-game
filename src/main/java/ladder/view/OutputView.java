package ladder.view;

import java.util.List;

import static ladder.LadderMain.MAX_LENGTH;

public class OutputView {

    public void drawPeople(List<String> people) {
        for (String person : people) {
            System.out.print(String.format("%-" + (MAX_LENGTH+1) + "s", person));
        }
        System.out.println();
    }

    public void drawLadder(List<String> result) {
        for (String s : result) {
            System.out.println(s);
        }
    }
}
