package stepone;

import java.util.Scanner;
import java.util.Random;

class Ladder {
    int ladderHeight, numPlayers;
    char[][] ladderArray;

    public Ladder(int ladderHeight, int numPlayers) {
        this.ladderHeight = ladderHeight;
        this.numPlayers = numPlayers;
    }

    void getLadder() {
        Random random = new Random();
        char[][] ladderArray = new char[ladderHeight][2*numPlayers-1];
        for (int i=0; i<ladderArray.length; i++) {
            ladderArray[i][0] = '|';
            for (int j=1; j<ladderArray[i].length; j+=2) {
                boolean isStep = random.nextBoolean();
                ladderArray[i][j] = isStep? '-' : ' ';
                ladderArray[i][j+1] = '|';
            }
        }
        this.ladderArray = ladderArray;
    }

    void printLadder() {
        for (char[] array : ladderArray)
            System.out.println(array);
    }
}

public class LadderStepOne {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("참여할 사람은 몇명인가요?");
        int numPlayers = scanner.nextInt();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int ladderHeight = scanner.nextInt();
        scanner.close();

        Ladder ladder = new Ladder(ladderHeight, numPlayers);
        ladder.getLadder();
        ladder.printLadder();
    }

}
