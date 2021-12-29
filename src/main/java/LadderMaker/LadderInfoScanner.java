package LadderMaker;

import java.util.*;

public class LadderInfoScanner {
    private final Scanner sc;

    public LadderInfoScanner() {
        sc = new Scanner(System.in);
    }

    public Ladder getLadder(){
        List<String> names = getNames();
        int heightOfLadder = getHeightOfLadder();

        return new Ladder(heightOfLadder, names);
    }

    private List<String> getNames(){
        boolean valid;
        List<String> splitNames;

        do {
            System.out.println("참여할 사람 이름을 입력하세요. (이름은 다섯글자 이하로 쉼표(,)로 구분하세요)");
            String names = sc.nextLine()
                            .replaceAll(" ", "");
            valid = checkNumOfPeople(names);
            splitNames = new ArrayList<>(Arrays.asList(names.split(",")));
            valid = valid && checkNameLength(splitNames);
        }while(!valid);

        return splitNames;
    }

    private boolean checkNumOfPeople(String names) {
        if (!names.contains(",")) {
            System.out.println("두 명 이상 입력해주세요.");
            return false;
        }
        return true;
    }

    private boolean checkNameLength(List<String> splitNames){
        boolean anyNotValid = splitNames.stream()
                        .allMatch(name ->
                                name.length() <= Constant.MAX_NAME_LENGTH && name.length() >= Constant.MIN_NAME_LENGTH);
        if(!anyNotValid){
            System.out.println("한 글자 이상, 다섯 글자 이하의 이름을 사용해주세요.");
            return false;
        }
        return true;
    }

    private int getHeightOfLadder(){
        int heightOfLadder = 0;
        boolean valid;
        do {
            try{
                System.out.println("최대 사다리 높이는 몇 개인가요?");
                heightOfLadder = sc.nextInt();
                valid = checkHeightOfLadder(heightOfLadder);
            }catch(InputMismatchException notInt){
                System.out.println("정수를 입력해주세요.");
                valid = false;
            }
        }while(!valid);

        // catch(NumberFormatException outOfBoundary){ System.out.println("1 이상의 정수로 입력해주세요."); } // 1 미만 입력
        // Exception 분리하고 싶었지만 메서드 10줄 미만 제한으로 보류.

        return heightOfLadder;
    }

    private boolean checkHeightOfLadder(int heightOfLadder){
        if(heightOfLadder < Constant.MIN_HEIGHT_LENGTH) {
            System.out.println("사다리 길이는 1이상의 정수로 해주세요.");
            return false;
        }
        return true;
    }
}