package LadderMaker.Day1;

import java.util.ArrayList;

public class LadderWith2DArrayList extends Ladder {
    public LadderWith2DArrayList(int person, int height){
        ladderFlow(person, height);
    }

    @Override
    public Object makeLadder(int person, int height) {
        ArrayList<ArrayList<Character>> ladderList = new ArrayList<ArrayList<Character>>(height);
        for(int i = 0; i < height; i++){
            ArrayList<Character> characterList = new ArrayList<Character>(person * 2);
            for(int j = 0; j < person * 2 - 1; j++) characterList.add(randomCharacter(j));
            characterList.add('\n');
            ladderList.add(characterList);
        }

        return ladderList;
    }

    @Override
    public void drawLadder(Object ladder) {
        ArrayList<ArrayList<Character>> ladderList = (ArrayList<ArrayList<Character>>) ladder;
        ladderList.stream()
                .forEach(characterList->characterList.stream()
                        .forEach(System.out::print));
    }
}
