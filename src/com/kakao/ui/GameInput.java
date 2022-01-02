package com.kakao.ui;

import com.kakao.exception.CheckGameIO;

import java.util.*;

public class GameInput {

    private static final CheckGameIO checkInput = new CheckGameIO();
    private Scanner sc = new Scanner(System.in);
    private int participantCnt;

    public List<String> inputParticipants() {
        System.out.println("\n참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요.)");
        try {
            String participantsInput = sc.nextLine();
            checkInput.checkParticipantsException(participantsInput);
            String[] participants = participantsInput.split(",");
            participantCnt = participants.length;
            return Arrays.asList(participants);
        } catch (RuntimeException e) {
            sc = new Scanner(System.in);
            return inputParticipants();
        }
    }

    public int inputHeight() {
        System.out.println("\n최대 사다리 높이는 몇 개인가요?");
        try {
            int height = sc.nextInt();
            checkInput.checkHeightException(height);
            sc.nextLine();
            return height;
        } catch (InputMismatchException e) {
            System.out.println("\n사다리 높이는 1 이상의 정수값만 가능합니다.");
            sc = new Scanner(System.in);
            return inputHeight();
        }
    }

    public List<String> inputResults() {
        System.out.println("\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요.)");
        try {
            String resultsInput = sc.nextLine();
            checkInput.checkResultsException(resultsInput, participantCnt);
            String[] results = resultsInput.split(",");
            return Arrays.asList(results);
        } catch (RuntimeException e) {
            sc = new Scanner(System.in);
            return inputResults();
        }
    }

    public String inputCheckParticipant() {
        System.out.println("\n결과를 보고 싶은 사람은?");
        String participant = sc.nextLine();
        return participant;
    }

}
