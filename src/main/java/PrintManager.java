import java.util.List;

public class PrintManager {

    private static final String VLINE = "|";
    private static final String HLINE = "-----";
    private static final String SPACE = "     ";
    private static final String DELIMITER = " ";

    public PrintManager() {
    }
    public static void printPeople(String[] namePeople){
        StringBuilder stringNamePeople = new StringBuilder();

        for(String name : namePeople){
            stringNamePeople.append(String.format("%-5s",name)).append(DELIMITER);
        }
        System.out.println(stringNamePeople);
    }

    public static void printLadder(List<Line> ladder){
        StringBuilder stringLadder = new StringBuilder();

        for (Line line : ladder) {
            stringLadder.append("  ");
            printHorizontalLine(line, stringLadder);
            stringLadder.append(VLINE).append("\n");
        }
        System.out.println(stringLadder);
    }
    private static void printHorizontalLine(Line line, StringBuilder stringLadder){
        for(int j = 0; j< line.getPoints().size(); j++){
            stringLadder.append(VLINE).append(isLadder(line,j));
        }
    }

    private static String isLadder(Line line, int j){
        return line.getPoints().get(j)? HLINE : SPACE;
    }
}
