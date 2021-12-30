package main.java;

import main.java.ladder.view.LadderGameInput;
import main.java.ladder.view.LadderView;
import main.java.ladder.view.LadderInput;

import java.util.Scanner;

public class Application {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        LadderInput input = new LadderInput();
        LadderView ladderView = new LadderView(input.getPlayers(), input.getResults(), input.getHeight());
        System.out.println(ladderView.printLadderResult());

        LadderGameInput ladderGameInput = new LadderGameInput();
        ladderGameInput.playGame(ladderView.getLadder(), input);
    }
}