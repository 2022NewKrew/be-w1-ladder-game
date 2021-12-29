package laddergame;

import java.util.ArrayList;
import java.util.Scanner;

public class LadderGame {
    public static void main(String[] args){
        Ladder ld = new Ladder();
        ArrayList<String> participants;ld.getParticipantList();

        Scanner sc = new Scanner(System.in);
//        System.out.println("참여할 사람은 몇명인가요?");
//        ld.setPersonNum(sc.nextInt());
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        ld.setParticipants(sc.nextLine());
        ld.setParticipantList();
        ld.setPersonNum();
        participants = ld.getParticipantList();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        ld.setLadderHeight(sc.nextInt());
        System.out.println();

        for (int i=0;i<participants.size();i++){
            System.out.printf("%6s",participants.get(i));
        }
        System.out.println();

        ld.makeBasicLadder();
        ld.makeCompleteLadder();
    }
}