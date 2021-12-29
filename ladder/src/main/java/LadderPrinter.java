import java.util.Arrays;
import java.util.List;

public class LadderPrinter {
    public static void print(Ladder ladder){
        ladder.getLadderShape().forEach(LadderPrinter::printRow);
    }

    private static void printRow(List<Boolean> row){
        row.stream()
            .map(barExists -> barExists? "|-": "| ")
            .forEach(System.out::print);
        System.out.println("|");
    }
}
