import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int personNum, ladderHeight;
        Scanner sc = new Scanner(System.in);
        System.out.println("참여할 사람은 몇 명인가요?");
        personNum = sc.nextInt();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        ladderHeight = sc.nextInt();
        Ladder ladder = new Ladder(personNum, ladderHeight);
        ladder.printLadder();
    }
}
