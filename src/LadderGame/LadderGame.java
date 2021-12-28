package LadderGame;

import java.util.Scanner;

public class LadderGame {
    public int peopleNum, ladderHeight;

    public void inputData() {
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("참여할 사람은 몇 명인가요?");
        peopleNum = inputScanner.nextInt();

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        ladderHeight = inputScanner.nextInt();

        inputScanner.close();
    }

    public void startGame(){
        inputData();
        Ladder ladder = new Ladder(peopleNum, ladderHeight);
        ladder.printLadder();
    }
}
