import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Ladder ladder = getInfo();
        PrintLadder.print(ladder);
    }

    public static Ladder getInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("참여할 사람은 몇 명인가요?");
        int numOfPlayers = scanner.nextInt();
        System.out.println("최대 사다리 높이는 얼마인가요?");
        int height = scanner.nextInt();
        return new Ladder(height, numOfPlayers);
    }

}