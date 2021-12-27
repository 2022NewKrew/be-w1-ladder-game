package LadderMaker.Day1;

import java.util.ArrayList;

public class LadderWithSingleArrayList extends Ladder{
    public LadderWithSingleArrayList(int person, int height){
        ladderFlow(person, height);
    }


    @Override
    public Object makeLadder(int person, int height) {
        ArrayList<StringBuilder> ladderList = new ArrayList<StringBuilder>(height);
        for(int i = 0; i < height; i++){
            StringBuilder sb = new StringBuilder(person * 2);
            for(int j = 0; j < person * 2 - 1; j++) sb.append(randomCharacter(j));
            ladderList.add(sb);
        }

        return ladderList;
    }

    @Override
    public void drawLadder(Object ladder) {
        ArrayList<StringBuilder> ladderList = (ArrayList<StringBuilder>) ladder;
        ladderList.stream()
                .forEach(System.out::println);
    }
}
