package view;

import domain.Ladder;

import java.util.Arrays;

public class OutputView {
    public static void printLadder(Ladder ladder) {
//        System.out.println(ladder);
        System.out.println(ladder.getLadder());
        System.out.println(ladder.getLadder().size());
        System.out.println(ladder.getLadder().get(0));
//        ladder.getLadder().get()

        }
}
