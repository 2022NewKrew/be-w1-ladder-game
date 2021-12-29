public class PrintManager {

    private static final String vLine = "|";
    private static final String hLine = "-";
    private static final String space = " ";

    public PrintManager() {
    }

    public static void printLadder(boolean[][] ladder){
        StringBuilder stringLadder = new StringBuilder();

        for(int i=0; i<ladder.length; i++){
            printHorizontalLadder(i,stringLadder,ladder);
            stringLadder.append(vLine).append("\n");
        }
        System.out.println(stringLadder);
    }
    private static void printHorizontalLadder(int height, StringBuilder stringLadder, boolean[][] ladder){
        for(int j = 0; j< ladder[0].length; j++){
            stringLadder.append(vLine).append(isLadder(height, j, ladder));
        }
    }

    private static String isLadder(int i, int j, boolean[][] ladder){
        return ladder[i][j]? hLine : space;
    }
}
