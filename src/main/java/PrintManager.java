public class PrintManager {

    private static final String VLINE = "|";
    private static final String HLINE = "-";
    private static final String SPACE = " ";

    public PrintManager() {
    }

    public static void printLadder(boolean[][] ladder){
        StringBuilder stringLadder = new StringBuilder();

        for(int i=0; i<ladder.length; i++){
            printHorizontalLadder(i,stringLadder,ladder);
            stringLadder.append(VLINE).append("\n");
        }
        System.out.println(stringLadder);
    }
    private static void printHorizontalLadder(int height, StringBuilder stringLadder, boolean[][] ladder){
        for(int j = 0; j< ladder[0].length; j++){
            stringLadder.append(VLINE).append(isLadder(height, j, ladder));
        }
    }

    private static String isLadder(int i, int j, boolean[][] ladder){
        return ladder[i][j]? HLINE : SPACE;
    }
}
