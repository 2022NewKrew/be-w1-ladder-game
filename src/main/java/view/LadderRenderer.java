package view;

import repository.Constant;
import repository.Ladder;

public class LadderRenderer {
    private int MAX_LENGTH = Constant.MAX_NAME_LENGTH;
    public LadderRenderer() { }

    public void renderLadder(Ladder ladder){
        MAX_LENGTH = Math.max(ladder.getMaxResultLength(), Constant.MAX_NAME_LENGTH);
        printNames(ladder);
        for(int row = 0; row < ladder.getHeightOfLadder(); row++){
            printRow(ladder, row);
        }
        printResults(ladder);
    }

    private void printResults(Ladder ladder){
        StringBuilder sb = new StringBuilder();
        ladder.getResultStream()
                .forEach(name -> {
                    sb.append(paddingStrings(name));
                    sb.append(" ");
                });
        System.out.println(sb);
    }

    private void printNames(Ladder ladder){
        StringBuilder sb = new StringBuilder();
        ladder.getNameStream()
                .forEach(name -> {
                    sb.append(paddingStrings(name));
                    sb.append(" ");
                });
        System.out.println(sb);
    }

    private String paddingStrings(String name){
        StringBuilder sb = new StringBuilder();
        int length = MAX_LENGTH - name.length();
        sb.append(" ".repeat(length / 2 + length % 2));
        sb.append(name);
        sb.append(" ".repeat(length / 2));
        return sb.toString();
    }

    private void printRow(Ladder ladder, int row){
        StringBuilder rowString = new StringBuilder(" ".repeat(MAX_LENGTH / 2));
        rowString.append(Constant.VERTICAL);
        ladder.getConnectedStream(row)
                .forEach(column -> {
                    rowString.append(getConnectedString(column.getConnected()));
                    rowString.append(Constant.VERTICAL);
                });
        System.out.println(rowString);
    }

    private String getConnectedString(boolean column){
        if(column) return Constant.HORIZON.repeat(MAX_LENGTH);
        return Constant.SPACE.repeat(MAX_LENGTH);
    }
}
