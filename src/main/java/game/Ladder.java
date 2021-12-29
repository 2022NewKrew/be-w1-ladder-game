package game;

import java.util.ArrayList;

public class Ladder {

    private final ArrayList<Row> rows = new ArrayList<>();
    final static int typeSize = 5;

    public Ladder(ArrayList<String> playerList, int height) {
        rows.add(new PlayerRow(playerList));
        for(int i = 0; i<height;i++ ) {
            rows.add(new LadderRow(playerList.size()));
        }
    }
    public void printLadder() {
        for(Row row : rows)
        {
            System.out.println(row.toString());
        }
    }
}