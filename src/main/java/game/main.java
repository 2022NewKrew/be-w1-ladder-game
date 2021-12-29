package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        ArrayList<String> playerList =  getPlayerInput("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        int height = getIntegerInput("최대 사다리 높이는 몇 개인가요?");

        Ladder ladder = new Ladder(playerList, height);
        ladder.printLadder();
    }

    private static ArrayList<String> getPlayerInput(String str) {

        System.out.println(str);
        String inputStr = sc.next();
        return new ArrayList<>(Arrays.asList(inputStr.split(",")));

    }

    private static int getIntegerInput(String str) {

        System.out.println(str);
        int result = -1;
        while (!sc.hasNextInt() || ((result = sc.nextInt()) < 0)) {

            System.out.println("양의 점수를 입력해 주세요.");
            sc.next();
        }
        return result;

    }
}