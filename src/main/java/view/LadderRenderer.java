package view;

import repository.Constant;
import repository.Ladder;

public class LadderRenderer {
    public LadderRenderer() { }

    public void renderLadder(Ladder ladder){
        printNames(ladder);
        for(int row = 0; row < ladder.getHeightOfLadder(); row++){
            printRow(ladder, row);
        }
    }

    private void printNames(Ladder ladder){
        StringBuilder sb = new StringBuilder();
        ladder.getPlayerStream()
                .forEach(name -> {
                    sb.append(paddingName(name.getName()));
                    sb.append(" ");
                });
        System.out.println(sb);
    }

    private String paddingName(String name){
        StringBuilder sb = new StringBuilder();
        int length = Constant.MAX_NAME_LENGTH - name.length();
        sb.append(" ".repeat(length / 2 + length % 2));
        sb.append(name);
        sb.append(" ".repeat(length / 2));
        return sb.toString();
    }

    private void printRow(Ladder ladder, int row){
        StringBuilder rowString = new StringBuilder("  ");
        rowString.append(Constant.VERTICAL);
        ladder.getConnectedStream(row)
                .forEach(column -> {
                    rowString.append(getConnectedString(column.getValid()));
                    rowString.append(Constant.VERTICAL);
                });
        System.out.println(rowString);
    }

    private String getConnectedString(boolean column){
        if(column) return Constant.HORIZON;
        return Constant.SPACE;
    }
}
