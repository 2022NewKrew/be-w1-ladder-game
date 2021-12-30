package step3.view;

import step3.domain.Ladder;
import step3.domain.LadderResult;
import step3.domain.Line;

import java.util.*;

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
        StringBuilder printLine = new StringBuilder("  ").append(COLUMN);
        for(Boolean point : line.getPoints()){
            printLine.append(printPoint(point));
            printLine.append(COLUMN);
        }
        System.out.println(printLine);
    }

    private void printFormat5(String str){
        int len = str.length();
        if(len < 3){
            System.out.printf("  %-3s ",str);
            return;
        }
        if(len == 3){
            System.out.printf(" %-4s ",str);
            return;
        }
        if(len > 5){
            str = str.substring(0,5);
        }
        System.out.printf("%-5s ",str);
    }
    private void printString(List<String> lists){
        for(String list : lists){
            printFormat5(list);
        }
        System.out.println();
    }
    private void printLadderResult(Ladder ladder){
        System.out.println("사다리 결과");
        //이름 출력
        printString(ladder.getPeople().getNameOfPeople());
        //사다리 출력
        for (Line line : ladder.getLadder()){
            printLine(line);
        }
        //결과 출력
        printString(ladder.getResult().getResult());
    }
    private boolean printPerson(Ladder ladder){
        String name = InputView.getInstance().inputName();
        if(name.equals("춘식이") || name.equals("0")){
            System.out.println("게임을 종료합니다.");
            return false;
        }
        else if(name.equals("all") ){
            List<String> names = ladder.getPeople().getNameOfPeople();
            List<String> result = ladder.getResult().getMappingResult();
            for(int i=0;i<names.size();i++){
                System.out.println(names.get(i) + " : " + result.get(i));
            }
            return true;
        }
        int index = ladder.getPeople().getNameIndex(name);
        if(index == -1){
            System.out.println("다시 입력하세요");
            return true;
        }
        System.out.println("실행 결과");

        System.out.println(ladder.getResult().getMappingResult(index));
        return true;
    }
    public void printLadder(Ladder ladder) {
        printLadderResult(ladder);
        while(printPerson(ladder));
    }

    public static OutputView getInstance() { return INSTANCE; }
}
