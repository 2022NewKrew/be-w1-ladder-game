public class LadderRenderer {

    public void render(Ladder ladder) {
        int lines = ladder.getPlayerNum();
        int maxLadderHeight = ladder.getMaxLadderHeight();

        for(int currentHeight = 0; currentHeight < maxLadderHeight; currentHeight++) {
            for(int currentLine = 0; currentLine < lines; currentLine++) {
                printLadder(ladder, currentLine, currentHeight);
            }
            System.out.println();
        }
    }

    private void printLadder(Ladder ladder, int currentLine, int height) {
        System.out.print("|");
        if(currentLine == ladder.getPlayerNum() - 1){
            return;
        }
        if (!ladder.isConnected(currentLine, currentLine+ 1, height)) {
            System.out.print(" ");
        } else {
            System.out.print("-");
        }
    }
}
