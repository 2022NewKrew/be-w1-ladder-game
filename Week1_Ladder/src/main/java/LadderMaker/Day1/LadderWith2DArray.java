package LadderMaker.Day1;

public class LadderWith2DArray extends Ladder{
    public LadderWith2DArray(int person, int height){
        ladderFlow(person, height);
    }

    @Override
    public Object makeLadder(int person, int height) {
        char[][] ladderList = new char[height][person * 2];
        for(int i = 0; i < height; i++){
            for(int j = 0; j < person * 2 - 1; j++) ladderList[i][j] = randomCharacter(j);
            ladderList[i][person * 2 - 1] = '\n';
        }

        return ladderList;
    }

    @Override
    public void drawLadder(Object ladder) {
        char[][] ladderList = (char[][]) ladder;
        for(int i = 0; i < ladderList.length; i++)
            for(int j = 0; j < ladderList[i].length; j++) System.out.print(ladderList[i][j]);
    }
}
