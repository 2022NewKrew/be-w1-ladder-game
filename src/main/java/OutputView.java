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
            printNameWithSpace(user, 6);
        }
        System.out.println();
    }

    private static void printNameWithSpace(String user, int space) {
        int frontSpace = (space - user.length()) / 2;
        for (int i = 0; i < frontSpace; i++) {
            System.out.print(" ");
        }
        System.out.print(user);
        for (int i = 0; i < space - frontSpace - user.length(); i++) {
            System.out.print(" ");
        }
    }

    private static void printLadderLine(Line row) {
        System.out.print("  |");
        for (Boolean isTrue : row.getpoints()) {
            System.out.print(isTrue ? "-----|" : "     |");
        }
        System.out.println();
    }
}

