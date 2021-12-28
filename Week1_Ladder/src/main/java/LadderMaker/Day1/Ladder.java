package LadderMaker.Day1;

import java.util.Random;

public abstract class Ladder {
    private boolean isEvenNumber(int j){
        if((j & 1) == 0) { return true; }
        return false;
    }

    protected char randomCharacter(int j){
        char[] ladderList = {'-', ' '};
        Random random = new Random();

        if(isEvenNumber(j)) { return '|'; }
        return ladderList[random.nextInt(ladderList.length)];
    }

    protected void ladderFlow(int person, int height){
        drawLadder(makeLadder(person, height));
    }

    protected abstract Object makeLadder(int person, int height);
    protected abstract void drawLadder(Object ladder);
}
