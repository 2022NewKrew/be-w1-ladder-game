public class LadderRenderer {

    public void render(Ladder ladder) {
        for(int currentHeight = 0; currentHeight < ladder.getMaxLadderHeight(); currentHeight++) {
            printHeight(ladder, currentHeight);
        }
    }

    private void printHeight(Ladder ladder, int height) {
        for(int currentLine = 0; currentLine < ladder.getPlayerNum(); currentLine++) {
            printLine(ladder, currentLine, height);
        }
        System.out.println();
    }

    private void printLine(Ladder ladder, int line, int height) {
        System.out.print("|");
        if(line == ladder.getPlayerNum() - 1){
            return;
        }
        if (!ladder.isConnected(line, line + 1, height)) {
            System.out.print(" ");
            return;
        }
        System.out.print("-");
    }
}
