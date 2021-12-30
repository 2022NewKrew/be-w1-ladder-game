package laddergame.view;

import laddergame.domain.Ladder;
import laddergame.util.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class GameView {
    private static Scanner sc = new Scanner(System.in);

    public static List<String> inputArrayList(String message, String gubun){
        System.out.println(message);
        String input = sc.nextLine();
        List<String> inputArrayList = new ArrayList<String>();
        for (String string : input.split(gubun)){
            inputArrayList.add(string);
        };
        return inputArrayList;
    }

    public static int inputInteger(String message){
        System.out.println(message);
        int inputInteger = sc.nextInt();
        sc.nextLine();
        return inputInteger;
    }

    public static String inputString(String message){
        System.out.println(message);
        return sc.nextLine();
    }

    public static void printLadderWithLabels(Ladder ladder, List<String> users, List<String> targets){
        printLabelLine(users, 5);
        System.out.println();
        System.out.print(ladder.toString());
        printLabelLine(targets, 5);
        System.out.println();
    }

    private static void printLabelLine(List<String> labels, int stringSize){
        for (String label : labels){
            System.out.print(Util.formatStringSize(label, stringSize));
            System.out.print(" ");
        };
    }

    public static void printResult(Map<String,String> result, String user){
        if(user.equals("all")) {
            printResult(result);
            System.out.println();
            return;
        }
        System.out.println(result.get(user));
        System.out.println();
    }

    private static void printResult(Map<String,String> result){
        for(String name : result.keySet()){
            System.out.println(name + " : " + result.get(name));
        }
    }
}
