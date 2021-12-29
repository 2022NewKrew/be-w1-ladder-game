import java.util.Scanner;

public class Main {
    public static Ladder makeLadder(int n, int m) {
        if(n == 1) {
            return new SingleLadder(m);
        }
        return new MultiLadder(n, m);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("참여할 사람은 몇 명인가요?");
        int n = sc.nextInt();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int m = sc.nextInt();
        Ladder ld = makeLadder(n, m);
        ld.printLadder();
    }
}
