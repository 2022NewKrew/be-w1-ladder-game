package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LadderInfoGetter {
    private List<String> people;
    private int heightOfLadder;

    public void getInfoFromClient() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        people = Arrays.asList(scanner.nextLine().split(","));
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        heightOfLadder = scanner.nextInt();
    }

    public List<String> getPeople() {
        return people;
    }

    public int getHeightOfLadder() {
        return heightOfLadder;
    }
}
