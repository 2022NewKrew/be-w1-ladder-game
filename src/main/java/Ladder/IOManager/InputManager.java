package Ladder.IOManager;

import Ladder.DTO.InputDTO;

import java.util.Scanner;

public class InputManager {
    static Scanner sc = new Scanner(System.in);

    private static int inputNumPeople() {
        System.out.println("참여할 사람은 몇 명인가요?");
        return sc.nextInt();
    }

    private static int inputHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return sc.nextInt();
    }

    public static InputDTO getInputDTO() {
        return new InputDTO(inputNumPeople(), inputHeight());
    }
}
