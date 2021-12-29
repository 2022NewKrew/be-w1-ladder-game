package view;

import java.util.List;
import java.util.Scanner;

public class ApplicationInput {
    private static final String DELIMITER = ",";
    static final Scanner sc = new Scanner(System.in);

    private final List<String> players;
    private final int height;

    public ApplicationInput() {
        players = userInputPlayers();
        height = userInputHeight();
        sc.close();
    }

    private List<String> userInputPlayers() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표로(,)로 구분하세요)");
        List<String> inputPlayers = List.of(sc.nextLine().split(DELIMITER));

        validatePlayers(inputPlayers);
        return inputPlayers;
    }

    private void validatePlayers(List<String> inputPlayers){
        if (inputPlayers.stream().anyMatch(name -> name.length() > 5))
            throw new IllegalArgumentException("사람 이름은 최대 5글자입니다.");
    }

    private int userInputHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int inputHeight = sc.nextInt();

        validateHeight(inputHeight);
        return inputHeight;
    }

    private void validateHeight(int inputHeight){
        if (inputHeight < 1)
            throw new IllegalArgumentException("사다리의 높이는 1이상입니다.");
    }

    public List<String> getPlayers() {
        return players;
    }

    public int getHeight() {
        return height;
    }
}
