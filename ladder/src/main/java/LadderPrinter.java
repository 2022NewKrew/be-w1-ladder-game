import java.util.List;

public class LadderPrinter {
    public static void print(Ladder ladder){
        printParticipants(ladder.getLines());
        printLadder(ladder);
    }

    private static void printLadder(Ladder ladder){
        for (int currentHeight = 0; currentHeight < ladder.getLadderHeight(); currentHeight++)
            printRow(ladder, currentHeight);
    }

    private static void printRow(Ladder ladder, int curHeight){
        System.out.print("   ");
        ladder.getLines().stream()
            .map(line -> mapBar(line, curHeight))
            .forEach(System.out::print);
        System.out.println();
    }

    private static String mapBar(Line line, int curHeight){
        if (line.getConnections()[curHeight] != null
                && line.getLineNum() < line.getConnections()[curHeight].getLineNum())
            return "|-----";
        return "|     ";
    }

    private static void printParticipants(List<Line> lines){
        lines.stream()
                .map(line -> line.getParticipant().getName())
                .forEach(name -> StringAlignManager.alignCenter(5, 1, name));
        System.out.println();
    }
}
