package com.kakao.step1;

import java.util.Scanner;

/**
 * author    : brody.moon
 * version   : 1.0
 * 사용자 입력을 위한 클래스입니다.
 * 잘못된 입력은 다시 입력받습니다.
 */
public class UserInput {
    /**
     * @param memberNum    참여 인원 수
     * @param ladderHeight 사다리 높이
     */
    private int memberNum;
    private int ladderHeight;

    public UserInput() {
        inputPlayerInfo();
    }

    /**
     * 입력을 받아 옳바른 요청으로 초기화 진행하는 함수입니다.
     *
     * @param
     */
    private void inputPlayerInfo() {
        Scanner sc = new Scanner(System.in);

        do {
            memberNum = readInput("참여할 사람은 몇 명인가요?", sc);
        } while (memberNum <= 0);

        do {
            ladderHeight = readInput("참여할 사람은 몇 명인가요?", sc);
        } while (ladderHeight <= 0);
    }

    /**
     * 사용자 입력을 받는 함수입니다.
     *
     * @param s  출력할 문자열
     * @param sc 입력을 받을 Scanner 객체
     * @return 사용자 지정 정수 ( 잘못된 입력의 경우 0 )
     */
    private int readInput(String s, Scanner sc) {
        System.out.println(s);

        int tempRandomNum = 0;

        try {
            tempRandomNum = sc.nextInt();
        } catch (Exception e) {
        }

        if (tempRandomNum <= 0) {
            System.out.println("1 이상의 양수 값을 입력해 주세요.");
        }

        return tempRandomNum;
    }

    public int getMemberNum() {
        return memberNum;
    }

    public int getLadderHeight() {
        return ladderHeight;
    }
}
