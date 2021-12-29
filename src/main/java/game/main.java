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
        ArrayList<String> arrayList = null;
        do {
            String inputStr = sc.next();
            arrayList = new ArrayList<>(Arrays.asList(inputStr.split(",")));
        }
        while (!isCorrectPlayerName(arrayList));
        // 적절하지 않은 플레이어 네임이면 다시 입력 해야 함.
        return arrayList;
    }

    private static boolean isCorrectPlayerName(ArrayList<String> arrayList) {
        if(arrayList.stream().filter(player -> player.length() > 5).count() >0)
        {
            System.out.println("플레이어의 이름은 최대 5자까지 가능합니다.\n 다시 입력해주세요.");
            return false;
        }
        if(arrayList.size() < 1)
        {
            System.out.println("플레이어를 한 명 이상 입력해주세요.");
            return false;
        }
        return true;
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