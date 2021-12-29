import java.util.Arrays;
import java.util.List;

public class LadderPrinter {
    public static void print(Ladder ladder){
        printParticipants(ladder.getParticipants());
        ladder.getLadderShape().forEach(LadderPrinter::printRow);
    }

    private static void printRow(List<Boolean> row){
        System.out.print("   ");
        row.stream()
            .map(barExists -> barExists? "|-----": "|     ")
            .forEach(System.out::print);
        System.out.println("|");
    }

    private static void printParticipants(List<Participant> participants){
        participants.stream()
                .map(Participant::getName)
                .forEach(name -> StringAlignManager.alignCenter(5, 1, name));
        System.out.println();
    }
}
