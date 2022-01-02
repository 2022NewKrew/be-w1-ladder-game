package main.java.view;

import main.java.domain.Ladder;
import main.java.domain.Print;

public class OutputView {

    private OutputView() {
    }

    public static void printLadder(Print ladder) {
        ladder.print();
    }

    public static void printResult(Ladder ladder, String name) {
        if (name.equals("all")) {
            for (int i = 0; i < ladder.getSize(); i++) {
                System.out.println(ladder.findNameByOrder(i) + " : " + ladder.findResultByOrder(i));
            }
            return;
        }
        int order = ladder.findOrderByName(name);
        String result = ladder.findResultByOrder(order);
        System.out.println(result);
    }
}
