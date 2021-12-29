package game;

import java.util.ArrayList;

public class Ladder {

    private final PlayerRow playerRow;
    private final ArrayList<LadderRow> ladderRowList = new ArrayList<>();
    public final static int typeSize = 5;

    public Ladder(ArrayList<String> playerList, int height) {
        playerRow = new PlayerRow(playerList);
        for(int i = 0; i<height;i++ ) {
            ladderRowList.add(new LadderRow(playerList.size()));
        }
    }
    public void printLadder() {
        System.out.println(playerRow.toString());
        for(LadderRow ladderRow : ladderRowList)
        {
            System.out.println(ladderRow.toString());
        }
    }
}