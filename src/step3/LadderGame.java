package step3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LadderGame {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int height;
        ArrayList<String> peoples;

        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        peoples = new ArrayList<String>(Arrays.asList(s.nextLine().split(",")));
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        height = s.nextInt();

        Ladder ladder = new Ladder(peoples, height);
        ladder.printLadder();
    }
}
