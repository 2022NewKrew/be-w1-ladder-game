package com.kakao.exception;

import java.util.*;

public class CheckGameInput {

    private static final int MAX_LENGTH = 5;

    public void checkParticipantsException(String input) {
        String[] participants = input.split(",");
        if (input.length() == 0 || participants.length == 0) {
            System.out.println("최소 1명의 참가자가 필요합니다.");
            throw new RuntimeException();
        }

        for (String name : participants) {
            checkMaxLength(name);
        }
    }

    private void checkMaxLength(String name) {
        if (name.length() < 1 || name.length() > MAX_LENGTH) {
            System.out.println("이름은 최소 1글자, 최대 5글자 입니다.");
            throw new RuntimeException();
        }
    }

    public void checkHeightException(int height) {
        if (height < 1) {
            System.out.println("사다리 높이는 1 이상의 정수값만 가능합니다.");
            throw new InputMismatchException();
        }
    }
}
