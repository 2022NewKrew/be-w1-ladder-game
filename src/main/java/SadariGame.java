import java.util.Scanner;

public class SadariGame {

    public static void main(String[] args) {
        printSadariGame(input());
    }

    private static Sadari input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("참여할 사람은 몇명인가요?");
        int numberOfPeople = sc.nextInt();
        System.out.println("최대 사다리 높이는 몇 개 인가요?");
        int numberOfLadder = sc.nextInt();

        return new Sadari(numberOfPeople, numberOfLadder);
    }

    private static void printSadariGame(Sadari sadari) {
        sadari.printSadariGame();
    }
}
