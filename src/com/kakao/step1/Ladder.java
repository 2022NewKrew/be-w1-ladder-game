package com.kakao.step1;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
 * author    : brody.moon
 * version   : 1.0
 * 사다리 클래스입니다.
 * 모든 멤버 변수가 final 이라 immutable class 입니다.
 * 초기화 할 때 사용자 입력을 받기 때문에 InputMismatchException 을 발생 시킬 수 있습니다.
 */
class Ladder {
    /**
     * @param memberNum 참여 인원 수
     * @param ladderHeight 사다리 높이
     * @param ladderStatus 사다리 모양
     */
    private final int memberNum;
    private final int ladderHeight;
    private final State[][] ladderStatus;

    /**
     * 사다리 연결 부분이 있는지 없는지를 enum 으로 만들었습니다.
     */
    private enum State {
        EXIST, NONEXIST
    }

    /**
     * @throws InputMismatchException 입력이 정수로 들어오지 않는 경우 발생
     */
    public Ladder(Map.Entry<Integer, Integer> entry) throws InputMismatchException {
        memberNum = entry.getKey();
        ladderHeight = entry.getValue();
        ladderStatus = new State[ladderHeight][memberNum];

        initLadderStatus();
    }

    public static Map.Entry<Integer, Integer> initInput(){
        Scanner sc = new Scanner(System.in);

        System.out.println("참여할 사람은 몇 명인가요?");
        int memberNum = sc.nextInt() - 1;

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int ladderHeight = sc.nextInt();

        if(memberNum < 0 || ladderHeight <= 0)
            throw new InputMismatchException();

        return new AbstractMap.SimpleEntry<>(memberNum,ladderHeight);
    }

    /**
     * 사다리 모양 결정 메서드입니다.
     *
     * @param
     */
    private void initLadderStatus() {
        Random random = new Random();

        for (int i = 0; i < ladderHeight; i++) {
            for (int j = 0; j < memberNum; j++) {
                ladderStatus[i][j] = (random.nextInt(2) == 0) ? State.EXIST : State.NONEXIST;
            }
        }
    }

    /**
     * 사다리 모양 출력 메서드입니다.
     *
     * @param
     */
    public void printLadder() {
        for (int i = 0; i < ladderHeight; i++) {
            System.out.print('|');

            Arrays.stream(ladderStatus[i]).forEach(
                    s -> System.out.print("" + (s == State.EXIST ? '-' : ' ') + "|")
            );

            System.out.println();
        }
    }
}