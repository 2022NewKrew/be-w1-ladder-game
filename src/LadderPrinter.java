import java.util.List;

public class LadderPrinter {
    private LadderPrinter() {
        //instance 생성 제한용 생성자
    }

    public static void printLadder(Ladder ladder) {
        List<LadderRow> ladderRows = ladder.getLadderRows();
        for (LadderRow row : ladderRows) {
            row.getRow().forEach(it -> System.out.print(it ? "|-" : "| "));
            System.out.println("|");
        }
    }
}
