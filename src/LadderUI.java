import java.util.Scanner;

public class LadderUI {

    private static Scanner scanner= new Scanner(System.in);

    public static int getNumOfUser(){
        System.out.println("참여할 사람은 몇 명인가요?");
        return scanner.nextInt();
    }

    public static int getHeight(){
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }

    public static void printLadder(Ladder ladder) {
        for (char[] line : ladder.getLadderMap())
            System.out.println(line);
    }
}
