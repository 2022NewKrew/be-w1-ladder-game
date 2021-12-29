package LadderGame;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LadderGame {
    private static final int MAX_LENGTH_OF_NAME = 5;
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
        validatePlayerNames();

        playerNum = playerNames.size();
    }

    private void validatePlayerNames(){
        playerNames.forEach(name -> {
            if (name.length() > MAX_LENGTH_OF_NAME) {
                throw new IllegalArgumentException(MAX_LENGTH_OF_NAME + "글자 이상의 이름이 포함되어 있습니다.");
            }
        });
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
