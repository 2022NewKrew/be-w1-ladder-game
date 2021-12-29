package laddergame;

import java.util.ArrayList;
import java.util.List;

public class GameManager{
    private int playerNum;              // 참가자 수
    private List<String> playerNames;   // 참가자 이름 List
    private Ladder ladder;              // Ladder 클래스

    GameManager(){}
    GameManager(String playerNames, int height){
        this.playerNames = new ArrayList<String>();         // 참가자 리스트 생성
        this.nameSplit(playerNames);                        // 입력받은 이름들을 나누어 저장
        this.playerNum = this.playerNames.size();

        this.ladder = new Ladder(playerNum-1, height);  // 사다리 인스턴스 생성
    }

    // 입력받은 이름들을 쉼표를 기준으로 나누어 담는 메소드
    private void nameSplit(String playerNames){
        for(String name: playerNames.split(","))
            this.playerNames.add(name);
    }

    // 라벨링하기 위해 이름의 길이를 일정하게 패딩하는 메소드
    private String paddingName(String name){
        String lpad = " ";
        String rpad = " ";
        final int max_len = 5;
        int remaining = max_len - name.length();

        int left = remaining / 2;
        int right = remaining / 2 + remaining % 2;

        return lpad.repeat(left) + name + rpad.repeat(right);
    }

    // 사다리에 참가자들의 이름을 라벨링하는 메소드
    private void printLabel(){
        System.out.print("   ");
        for(String name : playerNames){
            System.out.print(this.paddingName(name));
            System.out.print(" ");
        }
        System.out.print("\n");
    }

    // 사다리를 출력하는 메소드
    public void printLadder(){
        this.printLabel();
        this.ladder.printLadder();
    }
}