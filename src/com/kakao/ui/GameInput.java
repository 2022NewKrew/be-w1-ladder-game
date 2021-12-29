package com.kakao.ui;

import com.kakao.exception.GameInputException;

import java.util.*;

public class GameInput {

    private static final GameInputException exception = new GameInputException();

    private Scanner sc = new Scanner(System.in);

    public ArrayList<String> inputParticipants() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요.)");
        try {
            String participantsInput = sc.nextLine();
            exception.checkParticipantsException(participantsInput);
            String[] participants = participantsInput.split(",");
            return new ArrayList<>(Arrays.asList(participants));
        } catch (RuntimeException e) {
            sc = new Scanner(System.in);
            return inputParticipants();
        }
    }

    public int inputHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        try {
            int height = sc.nextInt();
            exception.checkHeightException(height);
            return height;
        } catch (InputMismatchException e) {
            sc = new Scanner(System.in);
            return inputHeight();
        }
    }

}
