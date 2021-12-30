package view;

import java.util.List;

public class LadderGameView {
    public void printLadderGameInformation(List<String> names, String ladderView) {
        System.out.println(String.join("", names));
        System.out.println(ladderView);
    }
}
