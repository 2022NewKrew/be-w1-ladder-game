package LadderMaker.Day1;

import java.util.Arrays;

public class LadderWith2DArray extends Ladder{
    public LadderWith2DArray(int person, int height){
        ladderFlow(person, height);
    }

    @Override
    protected Object makeLadder(int person, int height) {
        char[][] ladderList = new char[height][person * 2];
        for(int i = 0; i < height; i++) { makeRow(ladderList[i], person); }

        return ladderList;
    }

    @Override
    protected void drawLadder(Object ladder) {
        char[][] ladderList = (char[][]) ladder;
        Arrays.stream(ladderList)
                .forEach(rowList -> printCharArray(rowList));
    }

    private void makeRow(char[] rowList, int person){
        for(int i = 0; i < person * 2 - 1; i++) { rowList[i] = randomCharacter(i); }
        rowList[person * 2 - 1] = '\n';
    }

    private void printCharArray(char[] array){
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i]);
        }
    }
}
