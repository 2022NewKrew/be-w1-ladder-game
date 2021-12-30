package main.view;
import main.domain.LadderGame;
import main.domain.LadderGameInput;

import java.util.Scanner;

public class UI {
    private UI(){}

    public static LadderGameInput getLadderGameInfo() {
        try(Scanner sc = new Scanner(System.in)) {
            System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
            String[] names = sc.nextLine().split(",");
            System.out.println("최대 사다리 높이는 몇 개인가요?");
            int heightOfLadder = sc.nextInt();
            return new LadderGameInput(names, heightOfLadder);
        }
    }

    public static void printLadder(LadderGame ladderGame) {
        System.out.println("사다리 결과");
        ladderGame.printLadder();
    }

}
