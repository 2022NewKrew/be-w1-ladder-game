package view;

import entity.Ladder;
import entity.Player;
import manager.GameManager;

import java.util.ArrayList;
import java.util.List;

public class LadderPrinter {
    private static final LadderPrinter INSTANCE = new LadderPrinter();

    private LadderPrinter() { }

    public static LadderPrinter getInstance() { return INSTANCE; }

    public static String padRight(String s, int n) {
        return String.format("%-" + n + "s", s);
    }

    public void displayLadder(Ladder ladder){
        printPlayer(ladder.getPlayers());
        printLadder(ladder.getConnections());
    }

    private void printPlayer(ArrayList<Player> players){
        players.forEach(player -> {
            String name = player.getName();
            int len = name.length();
            String paddedName = padRight(name, (5 - len) / 2 + len);
            System.out.printf("%5s ", paddedName);
        });
        System.out.println();
    }

    private void printLadder(List<ArrayList<Boolean>> connections){
        connections.forEach(row -> {
            System.out.print("  │");
            row.forEach(item -> System.out.print(item ? "-----│" : "     │"));
            System.out.println();
        });
    }
}
