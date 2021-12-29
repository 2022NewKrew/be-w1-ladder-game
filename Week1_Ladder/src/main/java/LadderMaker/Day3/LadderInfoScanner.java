package LadderMaker.Day3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LadderInfoScanner {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MIN_HEIGHT_LENGTH = 1;
    private Scanner sc;

    public LadderInfoScanner() {
        sc = new Scanner(System.in);
    }

    public Ladder getLadder(){
        ArrayList<String> names = getNames();
        correctNames(names);
        int heightOfLadder = getHeightOfLadder();

        return new Ladder(heightOfLadder, names);
    }

    private ArrayList<String> getNames(){
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String names = sc.nextLine()
                        .replaceAll(" ", "");

        if(!names.contains(",")) {
            System.out.println("두 명 이상 입력해주세요.");
            return getNames();
        }

        ArrayList<String> arrayListNames = new ArrayList<String>(Arrays.asList(names.split(",")));
        if(checkNames(arrayListNames)) {
            System.out.println("이름은 한 글자 이상, 다섯글자 이하로 입력해주세요.");
            return getNames();
        }

        return arrayListNames;
    }

    /**
     * Check input names are valid.
     * If any name's length is over five or under one, it's not valid name.
     * @param names is String ArrayList which has name list.
     * @return true: non valid name exist. false: all names are valid.
     */
    private boolean checkNames(ArrayList<String> names){
        /* easy way with 2 depth.
        for(String name : names) {
            if(name.length() > 5 || name.length() < 1) return false;
        }
        return true;
        */
        ArrayList<Boolean> nameValidCheck = new ArrayList<Boolean>(names.size());
        names.forEach(name ->
                nameValidCheck.add((name.length() <= MAX_NAME_LENGTH && name.length() >= MIN_NAME_LENGTH))
        );
        return nameValidCheck.contains(false);
    }

    private void correctNames(ArrayList<String> names){
        for(int i = 0; i < names.size(); i++){
            names.set(i, getFiveName(names.get(i)));
        }
    }

    private String getFiveName(String name){
        StringBuilder sb = new StringBuilder();
        int size = MAX_NAME_LENGTH - name.length();
        for(int i = 0; i < size / 2 + size % 2; i++) sb.append(" ");
        sb.append(name);
        for(int i = 0; i < size / 2; i++) sb.append(" ");
        return sb.toString();
    }

    private int getHeightOfLadder(){
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int heightOfLadder;
        try {
            heightOfLadder = sc.nextInt();
            if(heightOfLadder < MIN_HEIGHT_LENGTH) throw new InputMismatchException();
        }catch(InputMismatchException notInt){
            System.out.println("1 이상의 정수로 입력해주세요.");
            return getHeightOfLadder();
        } // int 외 입력 + 1이하 정수 입력

        // catch(NumberFormatException outOfBoundary){ System.out.println("1 이상의 정수로 입력해주세요."); } // 1 미만 입력
        // Exception 분리하고 싶었지만 메서드 10줄 미만 제한으로 보류.

        return heightOfLadder;
    }
}