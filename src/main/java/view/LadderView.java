package view;

import domain.*;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;

public class LadderView {
    private static final String CREATE_LINE = "-----";
    private static final String BLANK_LINE = "     ";
    private static final String STICK = "|";
    private static final String PRINT_ALL = "all";

    private final LadderResult ladderResult;

    public LadderView(LadderResult ladderResult) {
        this.ladderResult = ladderResult;
    }

    public void printLadder(){
        StringBuilder sb = new StringBuilder();

        sb.append(printList(ladderResult.getPerson()));

        for(Line line : ladderResult.getLadder()){
            sb.append("  " + STICK);
            sb.append(printLine(line));
            sb.append("\n");
        }
        sb.append(printList(ladderResult.getResult()));
        System.out.print(sb);
    }

    public void printResult(String resultInput){
        String result = ladderResult.findResult(resultInput);
        if(resultInput.equals(PRINT_ALL)){
            result = printAllResult();
        }

        System.out.println(result);
    }

    private String printAllResult(){
        StringBuilder sb = new StringBuilder();

        ladderResult.findAllResult()
                .forEach((name, result) -> sb.append(String.format("%s : %s", name, result))
                        .append("\n"));

        return sb.toString();
    }

    private String printList(List<String> list){
        StringBuilder sb = new StringBuilder();

        list.forEach(str -> sb.append(StringUtils.center(str, 5)).append(" "));
        sb.append("\n");

        return sb.toString();
    }

    private String printLine(Line line){
        StringBuilder sb = new StringBuilder();
        line.getLine()
                .forEach(l -> sb.append(l ? CREATE_LINE : BLANK_LINE)
                        .append(STICK));
        return sb.toString();
    }
}
