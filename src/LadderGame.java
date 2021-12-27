import java.util.Scanner;

public class LadderGame {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("참여할 사람은 몇 명인가요?");
        int n = scan.nextInt();

        System.out.println("최대 사다리 높이는 몇 개 인가요?");
        int m = scan.nextInt();

        Ladder ladder = new Ladder(n, m);
        System.out.println(ladder);
    }
}
