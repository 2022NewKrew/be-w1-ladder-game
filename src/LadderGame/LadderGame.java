package LadderGame;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LadderGame {
    private List<String> playerNames;
    private int ladderHeight, playerNum;
    private final Scanner inputScanner;

    public LadderGame() {
        this.inputScanner =  new Scanner(System.in);
    }

    private void inputData() {
        inputPlayerNames();
        inputLadderHeight();
        inputScanner.close();
    }

    private void inputPlayerNames(){
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉽표(,)로 구분하세요)");
        String allPlayerNames = inputScanner.nextLine();
        playerNames = Arrays.asList(allPlayerNames.split(","));
        playerNum = playerNames.size();
    }

    private void inputLadderHeight(){
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        ladderHeight = inputScanner.nextInt();
    }

    public void startGame(){
        inputData();
        for(String name: playerNames){
            System.out.printf("%-6s", name);
        }
        Ladder ladder = new Ladder(playerNum, ladderHeight);
        System.out.println();
        ladder.printLadder();
    }
}
