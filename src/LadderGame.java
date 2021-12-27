import java.util.Random;
import java.util.Scanner;

public class LadderGame {

    public static int peopleNum, ladderHeight;
    public static boolean[][] hasRightLadder;

    public static void inputData(){
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("참여할 사람은 몇 명인가요?");
        peopleNum = inputScanner.nextInt();

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        ladderHeight = inputScanner.nextInt();

        inputScanner.close();
    }

    public static void printLadder(){
        makeLadder();

        for (int i = 0; i < ladderHeight; i++){
            for(int j = 0; j < peopleNum; j++){
                System.out.print("|");
                if(hasRightLadder[i][j]) System.out.print("-");
                else System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void makeLadder(){
        Random randomInstance = new Random();
        int ladderWidth = peopleNum;
        hasRightLadder = new boolean[ladderHeight][ladderWidth];

        for(int ladderRow = 0; ladderRow < ladderHeight; ladderRow++){
            for(int ladderCol = 0; ladderCol< ladderWidth-1; ladderCol++){
                hasRightLadder[ladderRow][ladderCol] = randomInstance.nextBoolean();
            }
        }
    }

    public static void main(String[] args) {
        inputData();
        printLadder();
    }
}