import java.util.Scanner;

public class LadderMain {
    public static int numPeople;
    public static int height;
    public static LadBuilder ladBuilder = new LadBuilder();

    public static void main(String[] args) {
        getInput();
        Ladder ladder = ladBuilder.createLadder(height, numPeople);
        printLadder(ladder);
    }

    public static void getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("참여할 사람은 몇 명인가요?");
        numPeople = scanner.nextInt();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        height = scanner.nextInt();
    }

    public static void printLadder(Ladder ladder) {
        for (char[] line : ladder.getLadder())
            System.out.println(line);
    }

}
