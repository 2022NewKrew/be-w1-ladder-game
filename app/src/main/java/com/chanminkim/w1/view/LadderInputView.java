package com.chanminkim.w1.view;

import com.chanminkim.w1.controller.LadderGameDTO;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LadderInputView {
    private final Scanner scanner = new Scanner(System.in);

    public LadderGameDTO getUserInput() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String playerNameInput = scanner.nextLine();
        System.out.println();

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int heightOfLadder = scanner.nextInt();
        System.out.println();

        return new LadderGameDTO(splitNameInput(playerNameInput), heightOfLadder);
    }

    private List<String> splitNameInput(String playersInput) {
        return Arrays.stream(playersInput.split(","))
                .map(String::trim)
                .collect(Collectors.toUnmodifiableList());
    }

}
