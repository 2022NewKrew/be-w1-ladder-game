public class OutputView {

    public static void printLadder(String[][] ladder) {
        for(String[] row : ladder) {
            printLadderLine(row);
        }
    }

    private static void printLadderLine(String[] row) {
        for (int i=0 ; i<row.length*2+1; i++) {
            System.out.print(getElement(row, i));
        }
        System.out.println();
    }

    private static String getElement(String[] row , int i) {
        if (i%2==1) {
            return row[i/2];
        }
        return "|";
    }
}
