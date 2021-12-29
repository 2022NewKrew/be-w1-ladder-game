package manager;

import entity.Ladder;
import entity.Player;
import view.LadderPrinter;

import java.util.ArrayList;
import java.util.Scanner;

public class GameManager {
    private static final GameManager INSTANCE = new GameManager();

    private static final Scanner sc = new Scanner(System.in);

    private Ladder ladder;

    private GameManager() { }

    public static GameManager getInstance() { return INSTANCE; }

    private void getLadderInput(){
        // TODO: 입력 예외처리
        System.out.println("참여할 사람은 몇 명인가요?");
        int numParticipant = sc.nextInt();

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = sc.nextInt();

        ArrayList<Player> players = getPlayerName(numParticipant);

        ladder = new Ladder(numParticipant, height, players);
    }

    private ArrayList<Player> getPlayerName(int numParticipant) {
        ArrayList<Player> players = new ArrayList<>();
        while(players.size() < numParticipant){
            System.out.println((players.size() + 1) + "번 플레이어의 이름을 입력하세요");
            String name = sc.next();
            // TODO: 사용자 이름 길이 제약조건 추가(최대 5글자)
            players.add(new Player(name));
        }
        return players;
    }

    public void run(){
        getLadderInput();
        LadderPrinter.getInstance().displayLadder(ladder);
    }
}