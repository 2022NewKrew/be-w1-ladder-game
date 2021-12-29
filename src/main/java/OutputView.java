import java.util.List;

public class OutputView {

    public static void printLadder(List<Line> ladder, List<String> users) {
        printNames(users);
        for (Line row : ladder) {
            printLadderLine(row);
        }
    }

    private static void printNames(List<String> users) {
        for (String user : users) {
            System.out.printf("%-6s", user);
        }
        System.out.println();
    }

    private static void printLadderLine(Line row) {
        System.out.print("  |");
        for (Boolean isTrue : row.getpoints()) {
            System.out.print(isTrue ? "-----|" : "     |");
        }
        System.out.println();
    }
}

