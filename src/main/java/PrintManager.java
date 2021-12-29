public class PrintManager {
    private final boolean[][] ladder;
    private final StringBuilder stringLadder = new StringBuilder();
    private final String vLine = "|";
    private final String hLine = "-";
    private final String space = " ";

    public PrintManager(boolean[][] ladder) {
        this.ladder = ladder;
    }
    public void printLadder(){
        for(int i=0; i<ladder.length; i++){
            printHorizontalLadder(i);
            stringLadder.append(vLine).append("\n");
        }
        System.out.println(stringLadder);
    }
    private void printHorizontalLadder(int height){
        for(int j = 0; j< ladder[0].length; j++){
            stringLadder.append(vLine).append(isLadder(height, j));
        }
    }

    private String isLadder(int i, int j){
        return ladder[i][j]? hLine : space;
    }
}
