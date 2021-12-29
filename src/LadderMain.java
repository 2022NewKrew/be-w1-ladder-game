import java.util.Scanner;

public class LadderMain {
    public static int numOfPeople;
    public static int height;

    public static void main(String[] args) {
        getInput();
        Ladder ladder = new Ladder(height, numOfPeople);
        printLadder(ladder);
    }

    public static void getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("참여할 사람은 몇 명인가요?");
        numOfPeople = scanner.nextInt();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        height = scanner.nextInt();
    }

    public static void printLadder(Ladder ladder) {
        for (char[] line : ladder.getLadder())
            System.out.println(line);
    }

}
