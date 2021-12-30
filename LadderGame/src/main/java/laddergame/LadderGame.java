package laddergame;

import laddergame.domain.GameManager;
import laddergame.view.StringEditor;

import java.util.Scanner;

public class LadderGame {
    public static void main(String[] args){
        int height;
        String playerNames;
        Scanner sc = new Scanner(System.in);

        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        playerNames = sc.next();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        height = sc.nextInt();

        StringEditor se = new StringEditor();
        GameManager game = new GameManager(se.nameSplit(playerNames), height);      // 사다리게임 인스턴스 생성
        game.printLadder();                                           // 사다리 출력
    }
}