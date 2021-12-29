package LadderMaker.Day3;

public class LadderRenderer {
    private static final String HORIZON = "-----";
    private static final String VERTICAL = "|";
    private static final String SPACE = "     ";

    public LadderRenderer() { }

    public void renderLadder(Ladder ladder){
        printNames(ladder);
        for(int row = 0; row < ladder.getHeightOfLadder(); row++){
            printRow(ladder, row);
        }
    }

    private void printNames(Ladder ladder){
        StringBuilder sb = new StringBuilder();
        ladder.getNameStream()
                .forEach(name -> {
                    sb.append(name);
                    sb.append(" ");
                });
        System.out.println(sb);
    }

    private void printRow(Ladder ladder, int row){
        StringBuilder rowString = new StringBuilder("  ");
        rowString.append(VERTICAL);
        ladder.getConnectedStream(row)
                .forEach(column -> {
                    rowString.append(getConnectedString(column));
                    rowString.append(VERTICAL);
                });
        System.out.println(rowString);
    }

    private String getConnectedString(boolean column){
        if(column) return HORIZON;
        return SPACE;
    }
}
