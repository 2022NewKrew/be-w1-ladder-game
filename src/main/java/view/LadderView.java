package view;

import domain.*;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class LadderView {
    private final LadderResult ladderResult;

    public LadderView(LadderResult ladderResult) {
        this.ladderResult = ladderResult;
    }

    public void printLadder(){
        StringBuilder sb = new StringBuilder();

        sb.append(printList(ladderResult.getPerson()));

        for(Line line : ladderResult.getLadder()){
            sb.append("  " + LadderConst.STICK);
            sb.append(printLadderLine(line));
            sb.append("\n");
        }
        sb.append(printList(ladderResult.getResult()));
        System.out.print(sb);
    }

    public void printResult(String inputResult){
        String result = ladderResult.findResult(inputResult);
        if(inputResult.equals(LadderConst.PRINT_ALL)){
            result = printAllResult();
        }

        System.out.println(result);
    }

    private String printAllResult(){
        StringBuilder sb = new StringBuilder();

        ladderResult.findAllResult()
                .forEach((name, result) -> sb.append(String.format("%s : %s\n", name, result)));

        return sb.toString();
    }

    private String printList(List<String> list){
        StringBuilder sb = new StringBuilder();

        list.forEach(str -> sb.append(StringUtils.center(str, LadderConst.OUTPUT_NAME_SIZE)).append(" "));
        sb.append("\n");

        return sb.toString();
    }

    private String printLadderLine(Line line){
        StringBuilder sb = new StringBuilder();
        line.getLine()
                .forEach(l -> sb.append(l ? LadderConst.CREATE_LINE : LadderConst.BLANK_LINE)
                        .append(LadderConst.STICK));
        return sb.toString();
    }
}
