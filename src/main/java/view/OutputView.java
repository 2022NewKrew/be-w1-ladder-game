package view;

import domain.Ladder;
import domain.Line;
import domain.ParticipantList;

import java.util.Arrays;

public class OutputView {
    private Ladder ladder;
    private ParticipantList participantList;

    public OutputView(Ladder ladder, ParticipantList participantList){
        this.participantList = participantList;
        this.ladder = ladder;
    }

    public void showMap(){
        System.out.println("실행결과");
        System.out.println();
        System.out.println(showParticipants());
        showLadder();
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

    public void showLadder(){
        for(Line line : ladder.getLines()) {
            System.out.println(line);
        }
    }
}