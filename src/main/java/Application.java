import java.util.Scanner;

public class Application {
    public static int numOfPeople;
    public static int heightOfLadder;

    public static void runApp() {
        input();

        Ladder ladder = new Ladder(heightOfLadder, numOfPeople);
        ladder.initialize();
        ladder.makeRandom();
        ladder.print();
    }
    
    public static void input() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("참여할 사람은 몇 명인가요?");
        numOfPeople = Integer.parseInt(scanner.nextLine());

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        heightOfLadder = Integer.parseInt(scanner.nextLine());
    }

    public static void main(String[] args) {
        runApp();
    }
}
