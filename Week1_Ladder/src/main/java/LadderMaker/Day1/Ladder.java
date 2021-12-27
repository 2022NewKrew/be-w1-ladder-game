package LadderMaker.Day1;

import java.util.Random;

public abstract class Ladder {
    /**
     * check is number even
     * @param j
     * @return
     */
    private boolean isEvenNumber(int j){
        if((j & 1) == 0) return true;
        return false;
    }

    /**
     * return random Character
     * @param j
     * @return
     */
    protected char randomCharacter(int j){
        char[] ladderList = {'-', ' '};
        Random random = new Random();
        if(isEvenNumber(j)) return '|';
        else return ladderList[random.nextInt(ladderList.length)];
    }

    protected void ladderFlow(int person, int height){
        drawLadder(makeLadder(person, height));
    }

    public abstract Object makeLadder(int person, int height);
    public abstract void drawLadder(Object ladder);
}
