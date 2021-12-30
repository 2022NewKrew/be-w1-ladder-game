package view;

import domain.Ladder;
import domain.Line;

import java.util.List;

public class LadderView {
    private static final String CREATE_LINE = "-----";
    private static final String BLANK_LINE = "     ";
    private static final String STICK = "|";
    private final Ladder ladder;

    public LadderView(Ladder ladder) {
        this.ladder = ladder;
    }

    public void view(List<String> userNames){
        userNames.forEach(user -> System.out.printf("%5s ", user));
        System.out.println();
        printLadder();
    }

    private void printLadder(){
        StringBuilder sb = new StringBuilder();

        for(Line line : ladder.getLadder()){
            sb.append("   " + STICK);
            sb.append(printLine(line));
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private String printLine(Line line){
        StringBuilder sb = new StringBuilder();
        line.getLine()
                .forEach(l -> sb.append(l ? CREATE_LINE : BLANK_LINE)
                        .append(STICK));

        return sb.toString();
    }
}
