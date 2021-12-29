package kakao2022.david.sadari.step3;

import java.util.ArrayList;

public class LadderUI {

    public static void printPeopleList(ArrayList<String> peopleList){
        for(String person : peopleList){
            System.out.printf("%-6s",person);
        }
        System.out.println();
    }

    public static void printLadder(ArrayList<Line> ladderBoard){
        for(Line line : ladderBoard){
            printLine(line.getPoints());
        }
    }

    private static void printLine(ArrayList<Boolean> points){
        StringBuilder ladderLine = new StringBuilder("  |");
        for (boolean point : points){
            ladderLine.append(getLine(point));
            ladderLine.append("|");
        }
        System.out.println(ladderLine);
    }

    private static String getLine(boolean point){
        return point? "-----" : "     ";
    }
}
