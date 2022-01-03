package view;


import domain.Item;
import domain.LadderGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class View {
    private final Scanner scanner;

    public View() {
        scanner = new Scanner(System.in);
    }

    public void print(LadderGame ladderGame) {
        System.out.println(System.lineSeparator() + "실행결과" + System.lineSeparator());
        new ViewLadderGame(ladderGame);
    }

    public LadderGame createLadderGameByPrompt() {
        List<Item> ladderInputs = createLadderInputsByPrompt();
        int ladderHeight = createLadderHeightByPrompt();
        return new LadderGame(ladderInputs.size(), ladderHeight, ladderInputs);
    }

    private List<Item> createLadderInputsByPrompt() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return tryToCreateLadderInputsFromUserInputUntilSuccess();
    }

    private List<Item> tryToCreateLadderInputsFromUserInputUntilSuccess() {
        try {
            return createLadderInputsFromUserInput();
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            return createLadderInputsByPrompt();
        }
    }

    private List<Item> createLadderInputsFromUserInput() {
        List<Item> ladderInputs = new ArrayList<>();
        for (String name : scanner.nextLine().split(",")) {
            ladderInputs.add(new Item(name.strip()));
        }
        return ladderInputs;
    }

    private int createLadderHeightByPrompt() {
        System.out.println(System.lineSeparator() + "최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }
}
