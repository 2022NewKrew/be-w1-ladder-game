package LadderGame.view;

import LadderGame.domain.GameResult.GameResult;
import LadderGame.domain.Ladder.Ladder;
import LadderGame.domain.Player.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LadderGame {
    private final List<Player> playerNames = new ArrayList<>();
    private final List<GameResult> gameResults = new ArrayList<>();
    private int ladderHeight, playerNum;
    private Ladder ladder;

    private void inputData() {
        try(Scanner inputScanner = new Scanner(System.in)){
            inputPlayerNames(inputScanner);
            inputGameResults(inputScanner);
            inputLadderHeight(inputScanner);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void inputPlayerNames(Scanner inputScanner){
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉽표(,)로 구분하세요)");
        List<String> allPlayerNames = Arrays.asList(inputScanner.nextLine().split(","));
        allPlayerNames.forEach(name -> playerNames.add(new Player(name.trim())));
        playerNum = playerNames.size();
    }

    private void inputGameResults(Scanner inputScanner){
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        List<String> allGameResults = Arrays.asList(inputScanner.nextLine().split(","));
        allGameResults.forEach(result -> gameResults.add(new GameResult(result.trim())));
        if(allGameResults.size() != playerNum) throw new IllegalArgumentException("실행 결과의 수가 플레이어의 수와 일치하지 않습니다.");
    }

    private void inputLadderHeight(Scanner inputScanner){
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        ladderHeight = inputScanner.nextInt();
        ladder = new Ladder(playerNum, ladderHeight);
    }

    public void startGame(){
        inputData();
        printLadderInfo();
    }

    private void printLadderInfo(){
        printPlayerNames();
        ladder.printLadder();
        printGameResults();
    }

    private void printPlayerNames(){
        for(Player player: playerNames){
            System.out.printf("%-6s", player.name);
        }
        System.out.println();
    }

    private void printGameResults(){
        for(GameResult gameResult: gameResults){
            System.out.printf("%-6s", gameResult.getResult());
        }
        System.out.println();
    }
}
