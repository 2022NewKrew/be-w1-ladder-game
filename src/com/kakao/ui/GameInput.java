package com.kakao.ui;

import java.util.*;

public class GameInput {

    private Scanner sc = new Scanner(System.in);

    public int setParticipants() {
        try {
            int participants = sc.nextInt();
            checkException(participants);
            return participants;
        } catch (InputMismatchException e) {
            System.out.println("참여할 사람은 몇 명인가요? (자연수를 입력해 주세요)");
            sc = new Scanner(System.in);
            return this.setParticipants();
        }
    }

    public int setHeight() {
        try {
            int height = sc.nextInt();
            checkException(height);
            return height;
        } catch (InputMismatchException e) {
            System.out.println("최대 사다리 높이는 몇 개인가요? (자연수를 입력해 주세요)");
            sc = new Scanner(System.in);
            return this.setHeight();
        }
    }

    private void checkException(int n) {
        if (n < 1) {
            throw new InputMismatchException();
        }
    }
}
