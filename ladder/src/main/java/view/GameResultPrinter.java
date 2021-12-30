package view;

import domain.Ladder;
import exception.IllegalInputException;

public class GameResultPrinter {
    public void printGameResult(Ladder ladder, String name){
        if (name.equals("춘식이"))
            return;

        System.out.println("실행결과");
        if(name.equals("all")) {
            ladder.getLines().forEach(line -> System.out.println(line.getParticipant().getName() + ": " + line.getResult(0).getName()));
            return;
        }

        try {
            System.out.println(findResultByName(ladder, name));
        }catch (IllegalInputException e){
            System.out.println(e.getMessage());
        }
    }

    private String findResultByName(Ladder ladder, String name){
        return ladder.getLines()
                .stream()
                .filter(line -> line.getParticipant().getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalInputException("없는 참가자입니다."))
                .getResult(0)
                .getName();
    }
}
