package view;

import domain.Ladder;
import domain.Line;
import domain.ParticipantList;
import domain.ResultList;

import java.util.Arrays;

public class OutputView {
    private Ladder ladder;
    private ParticipantList participantList;
    private ResultList resultList;

    public OutputView(Ladder ladder, ParticipantList participantList, ResultList resultList){
        this.participantList = participantList;
        this.ladder = ladder;
        this.resultList = resultList;
    }

    public void showMap(){
        System.out.println("실행결과");
        System.out.println();
        System.out.println(showParticipants());
        showLadder();
        System.out.println(showResultList());
    }

    public String showParticipants(){
        char[] participantsName = new char[(participantList.getListSize() + 1) * 6];
        Arrays.fill(participantsName,' ');
        for(int i = 0; i < participantList.getListSize(); i++){
            writeParticipantToCharArr(participantsName, i);
        }
        return new String(participantsName);
    }

    public void writeParticipantToCharArr(char[] charArr, int index){
        String participant = participantList.getParticipantName(index);
        for(int i = 0 ; i < participant.length(); i++){
            charArr[6 * index + 2
                    - (int)(participant.length() / 2)
                    + i] = participant.charAt(i);
        }
    }

    public String showResultList(){
        char[] resultsName = new char[(resultList.getListSize() + 1) * 6];
        Arrays.fill(resultsName,' ');
        for(int i = 0; i < resultList.getListSize(); i++){
            writeresultToCharArr(resultsName, i);
        }
        return new String(resultsName);
    }

    public void writeresultToCharArr(char[] charArr, int index){
        String result = resultList.getResultName(index);
        for(int i = 0 ; i < result.length(); i++){
            charArr[6 * index + 2
                    - (int)(result.length() / 2)
                    + i] = result.charAt(i);
        }
    }

    public void showLadder(){
        for(Line line : ladder.getLines()) {
            System.out.println(line);
        }
    }

    public void showResult(int index){
        int resultIndex = ladder.getResultIndex(index);
        String name = participantList.getParticipantName(index);
        String result = resultList.getResultName(resultIndex);
        System.out.println(name + " : " + result);
    }
}