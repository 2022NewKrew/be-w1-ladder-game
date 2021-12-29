package org.cs.finn.laddergame.view;

import org.cs.finn.laddergame.domain.Ladder;
import org.cs.finn.laddergame.domain.Member;

public class LadderView {

    public void print(final Ladder ladder) {
        for (String bridge : ladder.getLadderRows().get()) {
            printOneHeight(bridge);
        }
    }

    private void printOneHeight(final String bridge) {
        for (char ch : bridge.toCharArray()) {
            // '1' -> const 화
            System.out.print("|" + (ch == '1' ? "-" : " "));
        }
        System.out.println("|");
    }
}
