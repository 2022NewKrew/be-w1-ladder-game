import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class LadderGame {
    static int numberOfGamers;
    static int heightOfLadder;
    static ArrayList<ArrayList<String>> ladder = new ArrayList<ArrayList<String>>();

    public static void main(String[] args) {
        input();
        setLadder();
        printLadder();
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("참여할 사람은 몇 명인가요?");
        numberOfGamers = scanner.nextInt();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        heightOfLadder = scanner.nextInt();
    }

    public static void setLadder() {
        for(int i = 0 ; i < heightOfLadder; i++) {
            ArrayList<String> row = setLadderRow();
            ladder.add(row);
        }
    }

    public static ArrayList<String> setLadderRow() {
        Random rd = new Random();
        ArrayList<String> row = new ArrayList<String>();
        row.add("|");
        for(int j = 0 ; j < numberOfGamers-1 ; j++) {
            row.add(rd.nextBoolean() ? "-" : " ");
            row.add("|");
        }
        return row;
    }

    public static void printLadder() {
        for(int i = 0 ; i < heightOfLadder; i++) {
            for(int j = 0 ; j < ladder.get(i).size(); j++) {
                System.out.print(ladder.get(i).get(j));
            }
            System.out.println();
        }
    }
}
