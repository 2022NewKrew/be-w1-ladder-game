public class OutputView {

    public static void printLadder(String[][] ladder) {
        for(String[] row : ladder) {
            for(String el : row) {
                System.out.print(el);
            }
            System.out.println();
        }
    }
}
