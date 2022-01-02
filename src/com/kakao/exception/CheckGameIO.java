package com.kakao.exception;

import java.util.*;

public class CheckGameIO {

    private static final int MAX_LENGTH = 5;

    public void checkParticipantsException(String input) {
        String[] participants = input.split(",");
        if (input.length() == 0 || participants.length == 0) {
            System.out.println("\n최소 1명의 참가자가 필요합니다.");
            throw new RuntimeException();
        }

        for (String name : participants) {
            checkMaxLength(name);
        }

        checkSameName(participants);
    }

    private void checkSameName(String[] participants) {
        Set<String> nameSet = new HashSet<>(Arrays.asList(participants));
        if (nameSet.size() != participants.length) {
            System.out.println("\n중복된 참가자가 존재합니다.");
            throw new RuntimeException();
        }
    }

    private void checkMaxLength(String name) {
        if (name.length() < 1 || name.length() > MAX_LENGTH) {
            System.out.println("\n이름은 최소 1글자, 최대 5글자 입니다.");
            throw new RuntimeException();
        }
    }

    public void checkHeightException(int height) {
        if (height < 1) {
            throw new InputMismatchException();
        }
    }

    public void checkResultsException(String input, int participantCnt) {
        String[] results = input.split(",");
        if (results.length != participantCnt) {
            System.out.printf("\n참가자 수와 결과 개수가 맞지 않습니다. (참가자 수 : %d 명)", participantCnt);
            throw new RuntimeException();
        }
    }
}
