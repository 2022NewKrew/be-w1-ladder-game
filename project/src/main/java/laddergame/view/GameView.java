package laddergame.view;

import laddergame.domain.Ladder;
import laddergame.util.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static laddergame.util.Util.formatStringSize;

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

    public static List<String> inputTargets(){
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String input = sc.nextLine();
        List<String> inputTargets = new ArrayList<String>();
        for (String target : input.split(",")){
            inputTargets.add(target);
        };
        return inputTargets;
    }

    public static int inputLadderHeight(){
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return sc.nextInt();
    }

    public static void printLadderWithLabels(Ladder ladder, List<String> users, List<String> targets){
        printLabelLine(users, 5);
        System.out.println();
        System.out.print(ladder.toString());
        printLabelLine(targets, 5);
    }

    private static void printLabelLine(List<String> labels, int stringSize){
        for (String label : labels){
            System.out.print(Util.formatStringSize(label, stringSize));
            System.out.print(" ");
        };
    }
}
