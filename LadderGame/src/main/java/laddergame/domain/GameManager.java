package laddergame.domain;

import laddergame.view.UIprinter;

import java.util.List;

public class GameManager{
    private static final int maxPlayerNum = 5;  // 참가자 이름의 최대 길이

    private int playerNum;              // 참가자 수
    private List<String> playerNames;   // 참가자 이름 List
    private Ladder ladder;              // Ladder 클래스

    GameManager(){}
    public GameManager(List<String> playerNames, int height){
        this.playerNames = playerNames;
        this.playerNum = this.playerNames.size();
        this.ladder = new Ladder(playerNum-1, height);  // 사다리 인스턴스 생성
    }

    // 사다리를 출력하는 메소드
    public void printLadder(){
        UIprinter ui = new UIprinter();
        ui.printLabel(this.playerNames, maxPlayerNum);
        this.ladder.printLadder(maxPlayerNum);
    }
}