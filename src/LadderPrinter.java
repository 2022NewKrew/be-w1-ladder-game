import java.util.List;

public class LadderPrinter {
    void printLadder(Ladder ladder) {
        List<List<Boolean>> ladderData = ladder.getLadderData();
        for (List<Boolean> line : ladderData) {
            line.forEach(it -> System.out.print(it ? "|-" : "| "));
            System.out.println("|");
        }
    }
}
