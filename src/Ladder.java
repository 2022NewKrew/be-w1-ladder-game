package laddergame;

import java.util.*;
import laddergame.Line;

public class Ladder {
    private final int ladderHeight;
    private final int numOfPeople;
    private final int maxLengthOfPeopleName;
    private final String horizontalEmptyString = " ";

    private final List<String> peopleNameList;
    private List<Line> structure;

    public Ladder(int ladderHeight, int numOfPeople, List<String> peopleNameList) {
        this.ladderHeight = ladderHeight;
        this.numOfPeople = numOfPeople;
        this.peopleNameList = peopleNameList;
        this.maxLengthOfPeopleName = 5;
        setStructure();
    }

    public void setStructure() {

        this.structure = new ArrayList<Line>();
        for (int i = 0; i < ladderHeight; i++) {
            Line newline = new Line(numOfPeople,maxLengthOfPeopleName,peopleNameList.get(0).length()/2);
            structure.add(newline);
        }
    }

    public void printLadder() {
        printHighestLine();
        for(Line thisLine : structure) {
            thisLine.printLine();
        }
    }

    public void printHighestLine(){
        String peopleNameString = "";
        List<Integer> emptySpaceSizeList = getEmptySpaceSizeList();
        for (int i = 0; i < peopleNameList.size(); i++) {
            peopleNameString += peopleNameList.get(i);
            peopleNameString += horizontalEmptyString.repeat(emptySpaceSizeList.get(i));
        }
        System.out.println(peopleNameString);
    }

    public List<Integer> getEmptySpaceSizeList(){
        List<Integer> emptySpaceSizeList = new ArrayList<Integer>();
        for (int i = 0; i < peopleNameList.size()-1; i++) {
            emptySpaceSizeList.add( getEmptySpaceSize(i) );
        }
        emptySpaceSizeList.add(0);      //peopleNameList와 사이즈 맞추기 위해 설정.
        return emptySpaceSizeList;
    }

    //중앙 기준으로 좌우로 나와있는 길이의 합을 구하는 함수
    public int getEmptySpaceSize(int peopleNameListIndex){
        int leftWordLength = peopleNameList.get(peopleNameListIndex).length() - peopleNameList.get(peopleNameListIndex).length()/2 - 1;
        int rightWordLength = peopleNameList.get(peopleNameListIndex+1).length()/2;
        int totalWordLength =  leftWordLength + rightWordLength;
        return maxLengthOfPeopleName - totalWordLength;
    }
}
