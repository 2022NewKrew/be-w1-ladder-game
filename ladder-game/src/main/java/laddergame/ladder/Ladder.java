package laddergame.ladder;

import java.util.ArrayList;
import java.util.Arrays;

public class Ladder {
    private int personNum;
    private int ladderHeight;
    private String participants;
    private String result;
    private ArrayList<String> participantList;
    private ArrayList<String> resultList;
    private ArrayList<String> ladderResult;
    //    private ArrayList<ArrayList<Character>> ladder;
    private ArrayList<Line> ladder;

    public Ladder(String participants, String result, int ladderHeight){
        this.participants = participants;
        this.ladderHeight = ladderHeight;
        String [] people = participants.split(",");
        this.participantList = new ArrayList<String>(Arrays.asList(people));
        this.personNum = participantList.size();
        String [] tmpResult = result.split(",");
        this.result = result;
        this.resultList = new ArrayList<String>(Arrays.asList(tmpResult));
        this.ladderResult = new ArrayList<>();
    }

    public int getPersonNum() {
        return personNum;
    }

    public ArrayList<String> getLadderResult() {
        return ladderResult;
    }

//    public void setPersonNum() {
//        this.personNum = participantList.size();
//    }

    public int getLadderHeight() {
        return ladderHeight;
    }

//    public void setLadderHeight(int ladderHeight) {
//        this.ladderHeight = ladderHeight;
//    }

//    public String getParticipants() {
//        return participants;
//    }
//
//    public void setParticipants(String participants) {
//        this.participants = participants;
//    }

//    public void setParticipantList(){
//        String [] people = participants.split(",");
//        participantList = new ArrayList<String>(Arrays.asList(people));
//    }

    public ArrayList<String> getParticipantList(){
        return participantList;
    }

    public ArrayList<String> getResultList() {
        return resultList;
    }

    public void makeBasicLadder(){
        ladder = new ArrayList<>();
        for(int i=0;i<ladderHeight;i++){
            ladder.add(new Line(personNum));
        }
    }

    public void makeCompleteLadder(){
        for(int i=0;i<ladderHeight;i++){
            System.out.print("  ");
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
        if(columnNum%2==0) {
            System.out.print(drawColumn());
            return;
        }
        System.out.print(drawRow(rowNum, columnNum));
    }

    public char drawColumn(){
        return '|';
    }

    public String drawRow(int rowNum, int columnNum){
        if (ladder.get(rowNum).getLine().get(columnNum/2)){
            return "-----";
        }
        return "     ";
    }

    public void repeatPerson(){
        for (int i=0;i<personNum;i++){
            makeResult(i);
        }
    }

    public void makeResult(int personIdx){
        for (int i=0;i<ladderHeight;i++){
            ArrayList<Boolean> currentLine = ladder.get(i).getLine();
            if (personIdx==0){
                if (currentLine.get(0)){
                    personIdx++;
                }
            }
            else if (personIdx==personNum-1){
                if (currentLine.get(personIdx-1)){
                    personIdx--;
                }
            }
            else{
                if (currentLine.get(personIdx-1)){
                    personIdx--;
                }
                else if (currentLine.get(personIdx)){
                    personIdx++;
                }
            }
        }
        ladderResult.add(resultList.get(personIdx));
}
