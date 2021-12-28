package LadderMaker.Day1;

import java.util.ArrayList;

public class LadderWithSingleArrayList extends Ladder implements LadderWithArrayList{
    public LadderWithSingleArrayList(int person, int height){
        ladderFlow(person, height);
    }


    @Override
    protected Object makeLadder(int person, int height) {
        ArrayList<StringBuilder> ladderList = new ArrayList<StringBuilder>(height);
        for(int i = 0; i < height; i++){ ladderList.add((StringBuilder) makeRow(person)); }

        return ladderList;
    }

    @Override
    protected void drawLadder(Object ladder) {
        ArrayList<StringBuilder> ladderList = (ArrayList<StringBuilder>) ladder;
        ladderList.stream()
                .forEach(System.out::println);
    }

    @Override
    public Object makeRow(int person){
        StringBuilder sb = new StringBuilder(person * 2);
        for(int j = 0; j < person * 2 - 1; j++) sb.append(randomCharacter(j));

        return sb;
    }
}
