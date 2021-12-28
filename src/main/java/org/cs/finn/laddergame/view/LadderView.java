package org.cs.finn.laddergame.view;

import org.cs.finn.laddergame.domain.Ladder;

public class LadderView {

    public void print(final Ladder ladder) {
        for (String bridge : ladder.getLadderRows()) {
            printOneHeight(bridge);
        }
    }

    private void printOneHeight(final String bridge) {
        for (char ch : bridge.toCharArray()) {
            System.out.print("|" + (ch == '1' ? "-" : " "));
        }
        System.out.println("|");
    }
}
