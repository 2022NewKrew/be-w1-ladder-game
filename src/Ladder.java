import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Ladder {

    private final ArrayList<ArrayList<Boolean>> ladders = new ArrayList<>();
    private final Random random = new Random();
    private int width, height;

    void inputData() {
        Scanner sc = new Scanner(System.in);
        System.out.println("참여할 사람은 몇 명인가요?");
        width = sc.nextInt();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        height = sc.nextInt();
        sc.close();
    }

    void makeLadders() {
        for (int i = 0; i < height; i++) {
            setLaddersData();
        }
    }

    void setLaddersData() {
        ArrayList<Boolean> line = new ArrayList<>();
        for (int j = 0; j < width - 1; j++) {
            line.add(random.nextBoolean());
        }
        ladders.add(line);
    }

    void printLadders() {
        for (ArrayList<Boolean> ladder : ladders) {
            ladder.forEach(it -> System.out.print(it ? "|-" : "| "));
            System.out.println("|");
        }
    }

}
