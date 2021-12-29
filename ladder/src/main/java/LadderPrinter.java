import java.util.Arrays;

public class LadderPrinter {
    public static void print(Ladder ladder){
            Arrays.stream(ladder.getLadderShape()).forEach(LadderPrinter::printRow);
    }

    private static void printRow(Boolean[] row){
        Arrays.stream(row)
                .map(barExists -> barExists? "|-": "| ")
                .forEach(System.out::print);
        System.out.println("|");
    }
}
