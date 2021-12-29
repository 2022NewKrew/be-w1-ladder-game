package game;

import java.util.ArrayList;

public class Ladder {

    private final ArrayList<LadderRow> rows = new ArrayList<>();

    public Ladder(int numOfPerson, int height) {
        for(int i = 0; i<height;i++ )
            rows.add(new LadderRow(numOfPerson));
    }
    public void printLadder() {
        for(LadderRow ladderRow : rows)
        {
            System.out.println(ladderRow.toString());
        }
    }
}
