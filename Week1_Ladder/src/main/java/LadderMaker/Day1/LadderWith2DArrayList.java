package LadderMaker.Day1;

import java.util.ArrayList;

public class LadderWith2DArrayList extends Ladder implements LadderWithArrayList{
    public LadderWith2DArrayList(int person, int height){
        ladderFlow(person, height);
    }

    @Override
    protected Object makeLadder(int person, int height) {
        ArrayList<ArrayList<Character>> ladderList = new ArrayList<ArrayList<Character>>(height);
        for(int i = 0; i < height; i++){ ladderList.add((ArrayList<Character>) makeRow(person)); }

        return ladderList;
    }

    @Override
    protected void drawLadder(Object ladder) {
        ArrayList<ArrayList<Character>> ladderList = (ArrayList<ArrayList<Character>>) ladder;
        ladderList.stream()
                .forEach(characterList->characterList.stream()
                        .forEach(System.out::print));
    }

    @Override
    public Object makeRow(int person){
        ArrayList<Character> characterList = new ArrayList<Character>(person * 2);
        for(int j = 0; j < person * 2 - 1; j++) characterList.add(randomCharacter(j));
        characterList.add('\n');

        return characterList;
    }
}
