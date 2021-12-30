package view;

import domain.Ladder;
import domain.Line;

import java.util.Arrays;

public class OutputView {
    private Ladder ladder;
    private String[] participants;

    public OutputView(Ladder ladder, String[] participants){
        this.participants = participants;
        this.ladder = ladder;
    }

    public void showMap(){
        System.out.println("실행결과");
        System.out.println();
        System.out.println(showParticipants());
        showLadder();
    }

    public String showParticipants(){
        char[] participantsName = new char[(participants.length + 1) * 6];
        Arrays.fill(participantsName,' ');
        for(int i = 0; i < participants.length; i++){
            writeParticipantToCharArr(participantsName, i);
        }
        return new String(participantsName);
    }

    public void writeParticipantToCharArr(char[] charArr, int index){
        String participant = participants[index];
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