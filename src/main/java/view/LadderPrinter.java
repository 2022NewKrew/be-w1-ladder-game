package view;

import model.Ladder;
import model.Player;

import java.util.List;

public class LadderPrinter {
    private static final LadderPrinter INSTANCE = new LadderPrinter();

    private LadderPrinter() { }

    public static LadderPrinter getInstance() { return INSTANCE; }

    public static String padRight(String s, int n) {
        return String.format("%-" + n + "s", s);
    }

    public void displayLadder(Ladder ladder){
        StringBuilder sb = new StringBuilder();
        printPlayer(sb, ladder.getPlayers());
        printLadder(sb, ladder.getConnections());
        System.out.print(sb.toString());
    }

    private void printPlayer(StringBuilder sb, List<Player> players){
        players.forEach(player -> {
            String name = player.getName();
            int len = name.length();
            String paddedName = padRight(name, (5 - len) / 2 + len);
            sb.append(String.format("%5s ", paddedName));
        });
        sb.append("\n");
    }

    private void printLadder(StringBuilder sb, List<List<Boolean>> connections){
        connections.forEach(row -> {
            sb.append("  │");
            row.forEach(item -> sb.append(item ? "-----│" : "     │"));
            sb.append("\n");
        });
    }
}
