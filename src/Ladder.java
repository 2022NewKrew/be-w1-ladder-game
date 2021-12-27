import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Ladder {

    private ArrayList<ArrayList<Boolean>> ladders;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("참여할 사람은 몇 명인가요?");
        int n = sc.nextInt();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int m = sc.nextInt();
        Ladder ladder = new Ladder();
        ladder.makeLadders(n, m);
        ladder.printLadders();
    }

    void makeLadders(int n, int m) {
        Random random = new Random();
        ladders = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            ArrayList<Boolean> line = new ArrayList<>();
            for (int j = 0; j < n - 1; j++) {
                line.add(random.nextBoolean());
            }
            ladders.add(line);
        }
    }

    void printLadders() {
        for (ArrayList<Boolean> lines : ladders) {
            System.out.print("|");
            for (boolean isLine : lines) {
                if (isLine)
                    System.out.print("-");
                else
                    System.out.print(" ");
                System.out.print("|");
            }
            System.out.println();
        }
    }
}
