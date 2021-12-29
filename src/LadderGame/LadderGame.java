package LadderGame;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LadderGame {
    private List<String> playerNames;
    private int ladderHeight, playerNum;

    private void inputData() {
        try(Scanner inputScanner = new Scanner(System.in)){
            inputPlayerNames(inputScanner);
            inputLadderHeight(inputScanner);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void inputPlayerNames(Scanner inputScanner){
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉽표(,)로 구분하세요)");
        String allPlayerNames = inputScanner.nextLine();
        playerNames = Arrays.asList(allPlayerNames.split(","));
        playerNum = playerNames.size();
    }

    private void inputLadderHeight(Scanner inputScanner){
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        ladderHeight = inputScanner.nextInt();
    }

    public void startGame(){
        inputData();
        printPlayerNames();

        Ladder ladder = new Ladder(playerNum, ladderHeight);
        ladder.printLadder();
    }

    private void printPlayerNames(){
        for(String name: playerNames){
            System.out.printf("%-6s", name);
        }
        System.out.println();
    }
}
