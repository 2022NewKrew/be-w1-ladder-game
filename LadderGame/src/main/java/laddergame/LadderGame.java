package laddergame;

import java.util.Scanner;

public class LadderGame {
    public static void main(String[] args){
        int playerNum, height;
        Scanner sc = new Scanner(System.in);

        System.out.println("참여할 사람은 몇 명인가요?");
        playerNum = sc.nextInt();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        height = sc.nextInt();

        Ladder ladder = new Ladder(playerNum, height);      // 사다리 인스턴스 생성
        ladder.printLadder();                               // 사다리 출력
    }
}
