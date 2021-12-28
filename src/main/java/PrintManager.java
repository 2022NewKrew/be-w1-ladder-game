public class PrintManager {
    private final boolean[][] ladder;

    public PrintManager(boolean[][] ladder) {
        this.ladder = ladder;
    }
    public void printLadder(){
        StringBuilder stringLadder = new StringBuilder();
        String vLine = "|";

        for(int i=0; i<ladder.length; i++){
            for(int j = 0; j< ladder[0].length; j++){
                stringLadder.append(vLine).append(isLadder(i, j));
            }
            stringLadder.append(vLine).append("\n");
        }
        System.out.println(stringLadder);
    }

    private String isLadder(int i, int j){
        String hLine = "-";
        String space = " ";

        return ladder[i][j]? hLine : space;
    }
}
