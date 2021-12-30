package com.yapark97.laddergame.ladder.view;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class SimpleLadderInput implements LadderInput{
    private static SimpleLadderInput simpleLadderInput;
    private static final Scanner sc = new Scanner(System.in);

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
            maxHeight = sc.nextInt();
        } catch (InputMismatchException e) {
            throw new InputMismatchException("최대 사다리 높이는 정수여야 합니다.");
        }
        if (maxHeight <= 0) {
            throw new InputMismatchException("최대 사다리 높이는 1 이상이어야 합니다.");
        }
        return maxHeight;
    }
}
