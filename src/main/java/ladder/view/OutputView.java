package ladder.view;

import java.util.List;

public class OutputView {

    public void drawPeople(List<String> people) {
        for (String person : people) {
            System.out.print(String.format("%-6s", person));
        }
        System.out.println();
    }

    public void drawLadder(List<String> result) {
        for (String s : result) {
            System.out.println(s);
        }
    }
}
