import java.util.List;

public class LadderPrinter {
    public static void printLadder(Ladder ladder) {
        List<LadderRow> ladderRows= ladder.getLadderRows();
        for (LadderRow row : ladderRows) {
            row.getRow().forEach(it -> System.out.print(it ? "|-" : "| "));
            System.out.println("|");
        }
    }
}
