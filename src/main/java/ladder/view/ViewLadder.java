package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Line;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ViewLadder {
    private final List<String> statusCase = new ArrayList<>(List.of("-", " "));
    private final String defaultCase = "|";
    private final int maxLength;
    private final Ladder ladderObj;
    private final List<String> names;
    private final List<String> results;


    public ViewLadder(Ladder ladder, int maxLength, ArrayList<String> names, ArrayList<String> results){
        ladderObj = ladder;
        this.maxLength = maxLength;
        this.names = names;
        this.results = results;
    }

    public void printLadder(){
        StringBuilder sb = new StringBuilder();
        sb.append(casesToString(names));
        for(Line line : ladderObj.getLadder()){
            sb.append(lineToString(line, maxLength));
        }
        sb.append(casesToString(results));
        System.out.println(sb);
    }

    private String casesToString(List<String> cases){
        StringBuilder sb = new StringBuilder();
        for(String caseData: cases){
            String subData = StringUtils.substring(caseData, 0, maxLength);
            sb.append(StringUtils.center(subData, maxLength));
            sb.append(" ");
        }
        sb.append("\n");
        return sb.toString();
    }

    public String lineToString(Line line, int maxLength){
        StringBuilder sb = new StringBuilder();
        sb.append(" ".repeat(maxLength/2));
        for(int i : line.getLine())
            sb.append(defaultCase + statusCase.get(i).repeat(maxLength));
        sb.append(defaultCase + "\n");
        return sb.toString();
    }
}
