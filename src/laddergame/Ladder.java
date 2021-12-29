package laddergame;

import java.util.ArrayList;
import java.util.Arrays;

public class Ladder {
    private int personNum;
    private int ladderHeight;
    private String participants;
    private ArrayList<String> participantList;
//    private ArrayList<ArrayList<Character>> ladder;
    private ArrayList<Line> ladder;


    public int getPersonNum() {
        return personNum;
    }

    public void setPersonNum() {
        this.personNum = participantList.size();
    }

    public int getLadderHeight() {
        return ladderHeight;
    }

    public void setLadderHeight(int ladderHeight) {
        this.ladderHeight = ladderHeight;
    }

    public String getParticipants() {
        return participants;
    }

    public void setParticipants(String participants) {
        this.participants = participants;
    }

    public void setParticipantList(){
        String [] people = participants.split(",");
        participantList = new ArrayList<String>(Arrays.asList(people));
    }

    public ArrayList<String> getParticipantList(){
        return participantList;
    }

    public void makeBasicLadder(){
        ladder = new ArrayList<>();
        for(int i=0;i<ladderHeight;i++){
            ladder.add(new Line(personNum));
        }
    }

    public void makeCompleteLadder(){
        for(int i=0;i<ladderHeight;i++){
            System.out.print("    ");
            drawIteration(i);
            System.out.println();
        }
    }

    public void drawIteration(int rowNum){
        for(int i=0;i<personNum*2-1;i++){
            drawLine(rowNum, i);
        }
    }

    public void drawLine(int rowNum, int columnNum){
        if(columnNum%2==0) System.out.print(drawColumn());
        else System.out.print(drawRow(rowNum, columnNum));
    }

    public char drawColumn(){
        return '|';
    }

    public String drawRow(int rowNum, int columnNum){
        if (ladder.get(rowNum).getLine().get((int)(columnNum/2))){
            return "-----";
        }
        return "     ";
    }
}
