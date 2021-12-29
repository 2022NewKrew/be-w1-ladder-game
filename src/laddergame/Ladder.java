package laddergame;

import java.util.ArrayList;

public class Ladder {
    private int personNum;
    private int ladderHeight;
    private ArrayList<ArrayList<Character>> ladder;

    public int getPersonNum() {
        return personNum;
    }

    public void setPersonNum(int personNum) {
        this.personNum = personNum;
    }

    public int getLadderHeight() {
        return ladderHeight;
    }

    public void setLadderHeight(int ladderHeight) {
        this.ladderHeight = ladderHeight;
    }

    public void makeBasicLadder(){
        ladder = new ArrayList<>();
        for(int i=0;i<ladderHeight;i++){
            ladder.add(new ArrayList<Character>(personNum*2-1));
        }
    }

    public void makeCompleteLadder(){
        for(int i=0;i<ladderHeight;i++){
            drawIteration(i);
        }
    }

    public void drawIteration(int rowNum){
        int randomNum = (int)(Math.random()*(personNum-1)) * 2 + 1;
        for(int i=0;i<personNum*2-1;i++){
            drawLine(rowNum, i, randomNum);
        }
    }

    public void drawLine(int rowNum, int columnNum, int randomNum){
        if(columnNum%2==0) ladder.get(rowNum).add(drawColumn());
        else ladder.get(rowNum).add(drawRow(columnNum, randomNum));
    }

    public char drawColumn(){
        return '|';
    }

    public char drawRow(int columnNum, int randomNum){
        if (columnNum==randomNum) return '-';
        return ' ';
    }

    public void printLadder(){
        for(int i=0;i<ladder.size();i++){
            printLadderOneByOne(i);
        }
    }

    public void printLadderOneByOne(int rowNum){
        for(int i=0;i<ladder.get(rowNum).size();i++){
            System.out.print(ladder.get(rowNum).get(i));
        }
        System.out.println();
    }
    @Override
    public String toString() {
        return "Ladder{" +
                "ladder=" + ladder +
                '}';
    }
}
