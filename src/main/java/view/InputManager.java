package view;

import DTO.StartInfo;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputManager {
    private static final Scanner sc = new Scanner(System.in);
    private static final String DELIMITER =",";

    public static String makePrintName(){
        System.out.println("\n결과를 보고 싶은 사람은?");
        String key = new Scanner(System.in).nextLine();
        return key;
    }
    public static StartInfo makeStartInfo() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        List<String> namePeople = makeInputString();

        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요");
        List<String> resultString = makeInputString();

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int maxHeight = makeInputNumber();

        return new StartInfo(namePeople.size(), namePeople, resultString, maxHeight);
    }
    private static List<String> makeInputString() {
        boolean pass = false;
        List<String> namePeople;
        do {
            String strPeople = sc.nextLine();
            namePeople = Arrays.asList(strPeople.split(DELIMITER));
            pass = checkNameLength(namePeople);
        } while (!pass);
        return namePeople;
    }
    private static boolean checkNameLength(List<String> namePeople) {
        if(namePeople.stream().allMatch(name -> name.length()<=5)){
            return true;
        }
        System.out.println("항목은 5글자 이하로 정해주세요.");
        return false;
    }

    private static int makeInputNumber() {
        boolean pass = false;
        int value = 5;
        do {
            try {
                value = Integer.parseInt(sc.nextLine());
                pass = checkIntValue(value);
            } catch (NumberFormatException e) {
                System.out.println(value);
                System.out.println("양의 정수를 입력해주세요.");
            }
        }while(!pass);
        return value;
    }

    private static boolean checkIntValue(int value) {
        if (value <= 0) {
            throw new NumberFormatException();
        }
        return true;
    }
}


