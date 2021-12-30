package view.printer;

import domain.Ladder;
import domain.Participant;
import exception.IllegalInputException;

public class GameResultPrinter {
    public void printGameResult(Ladder ladder, String name){
        if (name.equals("춘식이"))
            return;

        System.out.println("\n실행결과");

        if(name.equals("all"))
            printAll(ladder);
        else {
            try {
                System.out.println(ladder.getResultByParticipant(name));
            } catch (IllegalInputException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("====================");
    }

    private void printAll(Ladder ladder){
        for (Participant participant: ladder.getParticipants()) {
            String name = participant.getName();
            System.out.println(name + ": " + ladder.getResultByParticipant(name));
        }
    }
}
