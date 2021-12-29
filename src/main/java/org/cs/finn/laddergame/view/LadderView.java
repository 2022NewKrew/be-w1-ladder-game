package org.cs.finn.laddergame.view;

import org.cs.finn.laddergame.domain.Ladder;

public class LadderView {

    public void print(final Ladder ladder) {
        if (ladder == null) {
            throw new RuntimeException("Ladder is null!");
        }

        for (String bridge : ladder.getLadderRows().get()) {
            printOneHeight(bridge);
        }
    }

    private void printOneHeight(final String bridge) {
        if (bridge == null || bridge.isBlank()) {
            throw new RuntimeException("bridge String is null or blank!");
        }

        for (char ch : bridge.toCharArray()) {
            // '1' -> const 화
            System.out.print("|" + (ch == '1' ? "-" : " "));
        }
        System.out.println("|");
    }
}
