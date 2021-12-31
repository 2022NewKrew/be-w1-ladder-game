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

    private void inputData(Scanner inputScanner) {
        inputPlayerNames(inputScanner);
        inputGameResults(inputScanner);
        inputLadderHeight(inputScanner);
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
        inputScanner.nextLine();
        ladder = new Ladder(playerNum, ladderHeight);
    }

    public void startGame(){
        try(Scanner inputScanner = new Scanner(System.in)){
            inputData(inputScanner);
            printLadderInfo();
            playGame(inputScanner);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void printLadderInfo(){
        System.out.println("사다리 결과");
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

    private void playGame(Scanner inputScanner){
        ladder.makeGameResult();
        while (true){
            System.out.println("결과를 보고 싶은 사람은?");
            String playerName = inputScanner.nextLine();
            System.out.println(getPlayerReward(playerName));
        }
    }

    private String getPlayerReward(String playerName){
        if(playerName.equals("all")){
            return getAllPlayerReward();
        }
        if(playerName.equals("춘식이")){
            System.out.println("게임을 종료합니다.");
            System.exit(0);
        }
        int playerIdx = findPlayerIdx(playerName);
        String reward = getPlayerRewardByPlayerIdx(playerIdx);
        return playerName + " : " + reward;
    }

    private String getAllPlayerReward(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < playerNum; i++){
            String playerName = playerNames.get(i).name;
            String reward = getPlayerRewardByPlayerIdx(i);
            sb.append(playerName).append(" : ").append(reward).append("\n");
        }
        return sb.toString();
    }

    private String getPlayerRewardByPlayerIdx(int playerIdx){
        return gameResults.get(ladder.getGameResult().get(playerIdx)).getResult();
    }

    private int findPlayerIdx(String playerName){
        for (int i = 0; i < playerNum; i++) {
            if(playerName.equals(playerNames.get(i).name)) {
                return i;
            }
        }
        throw new IllegalArgumentException("일치하는 플레이어가 없습니다.");
    }
}
