package game.frontendapi.usertoapp;

import java.util.Scanner;

public class UserInputInteger implements UserInput<String, Integer> {
    @Override
    public Integer askToUser(String message) {
        Scanner scn = new Scanner(System.in);
        Integer result = -1;
        while (result == -1) {
            System.out.println(message);
            result = tryIntegerScan(scn);
        }
        return result;
    }

    private Integer tryIntegerScan(Scanner scn) {
        Integer result;
        try {
            result = Integer.parseInt(scn.nextLine());
            throwExceptionIfMinus(result);
            return result;
        } catch (Exception e) {
            System.out.println("0 이상의 정수를 입력해 주셔야 합니다!");
            return -1;
        }
    }

    private void throwExceptionIfMinus(Integer n) throws Exception {
        if (n < 0) {
            throw new Exception();
        }
    }
}
