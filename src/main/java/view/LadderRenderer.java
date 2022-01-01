package view;

import java.util.ArrayList;

public class LadderRenderer {
    private final int maxNameLength;

    public LadderRenderer(int maxNameLength) {
        this.maxNameLength = maxNameLength;
    }

    public void render(String[] people, ArrayList<ArrayList<Boolean>> connections){
        StringBuilder ladderString = new StringBuilder();
        ladderString.append(renderName(people));

        int heightOfLadder = connections.size();
        for(int layer = 0; layer < heightOfLadder; layer++) {
            ladderString.append(renderOneLine(people, connections, layer));
        }
        System.out.println(ladderString);
    }
    public StringBuilder renderName(String[] people){
        StringBuilder allName = new StringBuilder();
        for(String name : people){
            allName.append(padding(name));
        }
        return allName.append("\n");
    }

    public String padding(String name){
        int leftPadding = (maxNameLength - name.length())/2;
        int rightPadding = maxNameLength - name.length() - leftPadding + 1;
        return " ".repeat(leftPadding) + name + " ".repeat(rightPadding);
    }

    public StringBuilder renderOneLine(String[] people, ArrayList<ArrayList<Boolean>> connections, int layer){
        StringBuilder ladderStringOneLine = new StringBuilder("  ");

        int numOfPeople = people.length;
        for(int person = 0; person < numOfPeople-1; person++){
            ladderStringOneLine.append("|");
            ladderStringOneLine.append(connections.get(layer).get(person) ? "-".repeat(maxNameLength) : " ".repeat(maxNameLength));
        }
        ladderStringOneLine.append("|\n");
        return ladderStringOneLine;
    }
}
