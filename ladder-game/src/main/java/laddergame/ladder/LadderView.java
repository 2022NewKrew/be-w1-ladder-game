package laddergame.ladder;


import laddergame.ladder.Ladder;

import java.util.Objects;
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

    public String resultInputUI(){
        System.out.println();
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return sc.nextLine();
    }

    public void participantOutputUI(Ladder ladder){
        System.out.println();
        for (int i = 0; i < ladder.getParticipantList().size(); i++) {
            System.out.printf("%-6s", ladder.getParticipantList().get(i));
        }
        System.out.println();
    }

    public void ladderOutputUI(Ladder ladder){
        ladder.makeBasicLadder();
        ladder.makeCompleteLadder();
    }

    public void resultOutputUI(Ladder ladder){
        for (int i = 0; i < ladder.getResultList().size(); i++) {
            System.out.printf("%-6s", ladder.getResultList().get(i));
        }
    }

    public void printResult(Ladder ladder){
        while (true){
            System.out.println();
            System.out.println("결과를 보고 싶은 사람은?");
            String target = sc.next();
            if (Objects.equals(target, "춘식이")){
                System.out.println();
                System.out.println("게임을 종료합니다");
                return;
            }
            else if (Objects.equals(target, "all")){
                System.out.println("실행 결과");
                for (int i=0;i<ladder.getResultList().size();i++) {
                    System.out.printf("%s : %s%n", ladder.getParticipantList().get(i), ladder.getLadderResult().get(i));
                }
            }
            else if (ladder.getParticipantList().contains(target)){
                System.out.println("실행 결과");
                System.out.printf("%s", ladder.getLadderResult().get(ladder.getParticipantList().indexOf(target)));
            }
        }

    }
}
