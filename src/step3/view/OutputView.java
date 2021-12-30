package step3.view;

import step3.domain.Ladder;
import step3.domain.Line;

public class OutputView {

    private static final OutputView INSTANCE = new OutputView();

    private final int REPEAT = 5;
    private final String BAR = "-".repeat(REPEAT);
    private final String BLANK = " ".repeat(REPEAT);
    private final String COLUMN = "|";

    private OutputView () { }

    private String printPoint(boolean isBar){
        if(isBar){
            return BAR;
        }
        return BLANK;
    }
    private void printLine(Line line){
        StringBuilder printLine = new StringBuilder("  |");
        for(Boolean point : line.getPoints()){
            printLine.append(printPoint(point));
            printLine.append(COLUMN);
        }
        System.out.println(printLine);
    }

    private void printName(String name){
        if(name.length() < 3){
            System.out.printf("  %-3s ",name);
            return;
        }
        System.out.printf("%-5s ",name);
    }
    public void printLadder(Ladder ladder) {
        System.out.println("실행결과");
        for(String name : ladder.getPeople().getNameOfPeople()){
            printName(name);
        }
        System.out.println();
        for (Line line : ladder.getLadder()){
            printLine(line);
        }
    }

    public static OutputView getInstance() { return INSTANCE; }
}
