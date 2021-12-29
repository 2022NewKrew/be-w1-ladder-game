package game;

import java.util.ArrayList;

public class Ladder {

    private final PlayerRowView playerRowView;
    private final ArrayList<LadderRow> ladderRowList = new ArrayList<>();
    public final static int typeSize = 5;

    public Ladder(ArrayList<String> playerList, int height) {
        playerRowView = new PlayerRowView(playerList);
        for(int i = 0; i<height;i++ ) {
            ladderRowList.add(new LadderRow(playerList.size()));
        }
    }
    public void printLadder() {
        System.out.println(playerRowView.DrawElement());
        for(LadderRow ladderRow : ladderRowList)
        {
            System.out.println(LadderRowView.DrawElement(ladderRow.getElementList()));
        }
    }
}