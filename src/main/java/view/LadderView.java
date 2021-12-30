package view;

import domain.Ladder;
import domain.Line;
import domain.Person;
import org.apache.commons.lang3.StringUtils;

public class LadderView {
    private static final String CREATE_LINE = "-----";
    private static final String BLANK_LINE = "     ";
    private static final String STICK = "|";
    private final Ladder ladder;
    private final Person person;

    public LadderView(Ladder ladder, Person person) {
        this.ladder = ladder;
        this.person = person;
    }

    public void view(){
        printUser();
        printLadder();
    }

    private void printUser(){
        StringBuilder sb = new StringBuilder();

        person.getPerson()
                .forEach(name -> sb.append(StringUtils.center(name, 5)).append(" "));

        System.out.println(sb);
    }

    private void printLadder(){
        StringBuilder sb = new StringBuilder();

        for(Line line : ladder.getLadder()){
            sb.append("  " + STICK);
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
