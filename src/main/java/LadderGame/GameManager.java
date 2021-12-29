package LadderGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameManager {
  private final int NAMELENGTH = 5;

  private String playerNames;
  private int ladderHeight;
  private int playerCount;
  private List<Player> playerList;
  private Ladder ladder;
  private Scanner scanner = new Scanner(System.in);
  private static GameManager mgr = new GameManager();

  private GameManager() {}

  public static GameManager getMgr() {
    return mgr;
  }

  void setGame() {
    System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    playerNames = scanner.next();
    System.out.println("최대 사다리 높이는 몇 개 인가요?");
    ladderHeight = scanner.nextInt();
    mgr.setPlayers();
    mgr.makeLadder();
  }

  private void setPlayers() {
    String[] names = playerNames.split(",");
    playerCount = names.length;
    playerList = new ArrayList<>();
    for (int i=0; i<names.length; i++) {
      playerList.add(new Player(names[i]));
    }
  }

  private void makeLadder() {
    ladder = new Ladder(ladderHeight, playerCount);
    ladder.makeLadder();
  }

  void printResult() {
    mgr.printPlayers();
    ladder.printLadder(NAMELENGTH);
  }

  private void printPlayers() {
    StringBuilder output = new StringBuilder();
    for (int i=0; i<playerList.size(); i++) {
      output.append(setNameLength(playerList.get(i).getName()));
      output.append(" ");
    }
    System.out.println(output);
  }

  private String setNameLength(String name) {
    return name.concat(" ".repeat(NAMELENGTH - name.length()));
  }
}
