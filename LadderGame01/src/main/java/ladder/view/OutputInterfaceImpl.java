package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Line;

import java.util.List;

public class OutputInterfaceImpl implements OutputInterface{

    public String makeNameLength5(String name){
        StringBuilder stringBuilder = new StringBuilder();
        int leftSpace =  name.length() < 5 ? 5-(int)name.length() : 0;

        stringBuilder.append(" ".repeat(leftSpace/2));
        stringBuilder.append((name.length() > 5 ? name.substring(0,5) : name));
        stringBuilder.append(" ".repeat(leftSpace - leftSpace/2));

        return stringBuilder.toString();
    }

    @Override
    public void printParticipants(List<String> participants) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String participant: participants) {
            stringBuilder.append(makeNameLength5(participant)).append(" ");
        }
        System.out.println(stringBuilder.toString());
    }

    @Override
    public void printLadder(Ladder ladder) {
        StringBuilder stringBuilder = new StringBuilder();
        for(Line line : ladder.getShape()){
            stringBuilder.append("  ").append(line);
        }
        System.out.println(stringBuilder.toString());
    }
}
