package laddergame;

import java.util.List;
import java.util.Arrays;
import java.util.Scanner;

import laddergame.Ladder;

// Ladder의 초기 값의 IO 관련 부분을 담당
public class LadderIO {

    static Scanner sc = new Scanner(System.in);
    static int numOfPeople;
    static int ladderHeight;
    static final String peopleNameSeperator = ",";
    static List<String> peopleNameList;

    public static void getNumOfPeopleIO() {
        System.out.println("참여 할 사람이름을 입력하세요.");
        peopleNameList = Arrays.asList(sc.next().split(peopleNameSeperator));
        numOfPeople = peopleNameList.size();
    }

    public static void getLadderHeightIO() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int input = sc.nextInt();
        ladderHeight = input;
    }

    // 할당된 변수들에 맞추어 Ladder Class를 생성.
    public static Ladder constructLadder() {
        Ladder ladder = new Ladder(ladderHeight, numOfPeople, peopleNameList);
        return ladder;
    }
}

