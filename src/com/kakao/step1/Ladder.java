package com.kakao.step1;

import java.util.Arrays;
import java.util.Random;

/**
 * author    : brody.moon
 * version   : 1.1
 * 사다리 클래스입니다.
 * 모든 멤버 변수가 final 이라 immutable class 입니다.
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
    private final Random random;

    /**
     * 사다리 연결 부분이 있는지 없는지를 enum 으로 만들었습니다.
     * EXIST    연결 부분 존재
     * NONEXIST 연결 부분 없음
     */
    private enum State {
        EXIST, NONEXIST
    }

    /**
     * @param input 사용자 입력
     */
    public Ladder(UserInput input) {
        this.memberNum = input.getMemberNum() - 1;
        this.ladderHeight = input.getLadderHeight();
        this.ladderStatus = new State[ladderHeight][memberNum];
        this.random = new Random();

        initLadderStatus();
    }

    /**
     * 사다리 모양 결정 메서드입니다.
     *
     * @param
     */
    private void initLadderStatus() {
        for (int i = 0; i < ladderHeight; i++) {
            initLadderColStatus(i);
        }
    }

    /**
     * 사다리 상태 한 행을 초기화 해주는 함수입니다.
     * 연속적인 연결은 제거합니다.
     *
     * @param row 배열 row 정보
     */
    private void initLadderColStatus(int row) {
        ladderStatus[row][0] = random.nextBoolean() ? State.EXIST : State.NONEXIST;

        for (int i = 1; i < memberNum; i++) {
            ladderStatus[row][i] = ladderStatus[row][i - 1] == State.EXIST ? State.NONEXIST
                    : random.nextBoolean() ? State.EXIST : State.NONEXIST;
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