package main.java;

import main.java.ladder.view.LadderView;
import main.java.ladder.view.LadderInput;

public class Application {
    public static void main(String[] args) {
        LadderInput input = new LadderInput();
        LadderView ladderView = new LadderView(input.getPlayers(), input.getHeight());
        System.out.println(ladderView.printLadder());
    }
}
