package laddergame;

import java.util.ArrayList;
import java.util.Scanner;
import laddergame.Ladder;

// Ladder의 초기 값의 IO 관련 부분을 담당
public class LadderIO {

    static Scanner sc = new Scanner(System.in);
    static int numOfPeople;
    static int ladderHeight;

    public static void getNumOfPeopleIO() {
        System.out.println("참여 할 사람은 몇 명인가요?");
        setLadderVariable("numOfPeople");
    }

    public static void getLadderHeightIO() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        setLadderVariable("ladderHeight");
    }

    public static void setLadderVariable(String variable) {
        int input = sc.nextInt();
        if (variable.equals("numOfPeople")) {
            numOfPeople = input;
        }
        if (variable.equals("ladderHeight")) {
            ladderHeight = input;
        }
    }

    // 할당된 변수들에 맞추어 Ladder Class를 생성.
    public static Ladder constructLadder() {
        Ladder ladder = new Ladder(ladderHeight, numOfPeople);
        return ladder;
    }
}

