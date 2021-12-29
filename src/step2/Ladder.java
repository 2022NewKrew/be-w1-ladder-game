package step2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Ladder {

    final String BAR = "-";
    final String EMPTY = " ";
    final String COLUMN = "|";

    int peopleNum;
    int ladderNum;
    List<String> ladderInfo;

    Ladder() {
        inputLadder();
        makeLadder();
    }

    //input
    void inputLadder() {
        Scanner sc = new Scanner(System.in);

        System.out.println("참여할 사람은 몇 명인가요?");
        peopleNum = sc.nextInt();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        ladderNum = sc.nextInt();
    }

    //make ladder step
    String isLadder() {
        Random random = new Random();
        if (random.nextBoolean())
            return BAR;
        return EMPTY;
    }
    //make ladder line
    String makeLadderLine(int num) {
        StringBuilder ladder = new StringBuilder(COLUMN);
        for(int i=0;i<num-1;i++) {
            ladder.append(isLadder()).append(COLUMN);
        }
        return ladder.toString();
    }
    //make ladder
    void makeLadder() {
        ladderInfo = new ArrayList<String>(ladderNum);
        for (int i = 0; i < ladderNum; i++) {
            ladderInfo.add(makeLadderLine(peopleNum));
        }
    }

    // print
    void printLadder() {
        for(String ladder : ladderInfo){
            System.out.println(ladder);
        }
    }
}
