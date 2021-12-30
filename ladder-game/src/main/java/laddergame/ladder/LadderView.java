package laddergame.ladder;


import laddergame.ladder.Ladder;

import java.util.Scanner;

public class LadderView {
    private static Scanner sc = new Scanner(System.in);
    public String participantInputUI(){
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return sc.nextLine();
    }

    public int heightInputUI(){
        System.out.println();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return sc.nextInt();
    }

    public void participantOutputUI(Ladder ladder){
        System.out.println();
        for (int i = 0; i < ladder.getParticipantList().size(); i++) {
            System.out.printf("%6s", ladder.getParticipantList().get(i));
        }
        System.out.println();
    }

    public void ladderOutputUI(Ladder ladder){
        ladder.makeBasicLadder();
        ladder.makeCompleteLadder();
    }
}
