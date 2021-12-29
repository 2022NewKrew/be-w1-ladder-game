import java.util.Scanner;

public class LadderMain {
    public static void main(String[] args){
        int numOfParticipants = PositiveIntScanner.getPositiveInt("참여할 사람은 몇명인가요?");
        int numOfLadderHeight = PositiveIntScanner.getPositiveInt("최대 사다리 높이는 몇 개인가요?");

        Ladder ladder = new Ladder(numOfParticipants, numOfLadderHeight);
        LadderPrinter.print(ladder);
    }
}
