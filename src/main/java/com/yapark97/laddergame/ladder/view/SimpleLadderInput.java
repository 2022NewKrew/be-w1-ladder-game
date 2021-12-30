package com.yapark97.laddergame.ladder.view;

import com.yapark97.laddergame.ladder.domain.Ladder;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class SimpleLadderInput implements LadderInput{
    private static SimpleLadderInput simpleLadderInput;
    private static final Scanner sc = new Scanner(System.in);
    private static final String ALL = "all";
    private static final String CUTE_CHOONSIK = "춘식이";

    private SimpleLadderInput() {}

    public static SimpleLadderInput getInstance() {
        if (simpleLadderInput == null) {
            simpleLadderInput = new SimpleLadderInput();
        }
        return simpleLadderInput;
    }

    @Override
    public List<String> takeParticipantsInput() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String input = sc.nextLine();

        List<String> participants = Arrays.asList(input.split(","));
        if (participants.size() <= 1) {
            throw new InputMismatchException("참여자 수는 2명 이상이어야 합니다.");
        }
        return participants;
    }

    @Override
    public int takeMaxHeightInput() {
        int maxHeight;

        System.out.println("\n최대 사다리 높이는 몇 개인가요?");
        try {
            maxHeight = Integer.parseInt(sc.nextLine());
        } catch (InputMismatchException e) {
            throw new InputMismatchException("최대 사다리 높이는 정수여야 합니다.");
        }
        if (maxHeight <= 0) {
            throw new InputMismatchException("최대 사다리 높이는 1 이상이어야 합니다.");
        }
        return maxHeight;
    }

    @Override
    public List<String> takeResultsInput(int num) {
        System.out.println("\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String input = sc.nextLine();

        List<String> results = Arrays.asList(input.split(","));
        if (results.size() != num) {
            throw new InputMismatchException("참여자 수와 실행결과 수는 같아야 합니다");
        }
        return results;
    }

    @Override
    public String selectParticipant(Ladder ladder) {
        System.out.println("\n결과를 보고 싶은 사람은?");
        String input = sc.nextLine();
        return input;
    }
}
