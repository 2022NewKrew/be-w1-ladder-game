package laddergame.view;

import laddergame.domain.Ladder;
import org.apache.commons.lang3.StringUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameView {
    private static Scanner sc = new Scanner(System.in);

    public static List<String> inputUsers(){
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String input = sc.nextLine();
        List<String> inputUsers = new ArrayList<String>();
        for (String name : input.split(",")){
            inputUsers.add(name);
        };
        return inputUsers;
    }

    public static int inputLadderHeight(){
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return sc.nextInt();
    }

    public static void printLadderWithUsers(Ladder ladder, List<String> users){
        for (String name : users){
            System.out.print(String.format("%5s",StringUtils.substring(name,0,5)));
            System.out.print(" ");
        };
        System.out.println();
        System.out.println(ladder.toString());
    }
}
