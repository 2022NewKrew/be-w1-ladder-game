package Ladder.view;

import Ladder.DTO.InputDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    static Scanner sc = new Scanner(System.in);

    private static List<String> inputNumPeople() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String people = sc.next();
        String[] split = people.split(",");

        return new ArrayList<>(Arrays.asList(split));
    }

    private static int inputHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return sc.nextInt();
    }

    public static InputDTO getInputDTO() {
        return new InputDTO(inputNumPeople(), inputHeight());
    }
}
