package game.frontendapi.usertoapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UserInputStrings implements UserInput<String, ArrayList<String>> {

    @Override
    public ArrayList<String> askToUser(String message) {
        Scanner scn = new Scanner(System.in);
        ArrayList<String> result = new ArrayList<>();
        while (result.size() == 0) {
            System.out.println(message);
            result = tryPlayersNamesScan(scn);
        }
        return result;
    }

    private ArrayList<String> tryPlayersNamesScan(Scanner scn) {
        String input = scn.nextLine();
        ArrayList<String> result = new ArrayList<>(Arrays.stream(input.split(",")).map(String::trim).filter(s -> s.length() > 0).collect(Collectors.toList()));

        if (result.stream().anyMatch(s -> s.length() > 5)) {
            result.clear();
            System.out.println("5자리 이하의 입력값을 넣어주세요.");
        }
        return result;
    }
}
