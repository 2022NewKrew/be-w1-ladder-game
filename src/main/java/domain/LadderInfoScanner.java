package domain;

import repository.Constant;
import repository.Ladder;
import repository.PlayerList;

import java.util.*;

public class LadderInfoScanner {
    private final Scanner sc;

    public LadderInfoScanner() {
        sc = new Scanner(System.in);
    }

    public Ladder getLadder(){
        List<String> names = getNames();
        List<String> results = getResults(names.size());
        PlayerList players = new PlayerList(getMaxResultLength(results));
        int heightOfLadder = getHeightOfLadder();

        players.initiatePlayers(names, results);

        return new Ladder(heightOfLadder, players);
    }

    private int getMaxResultLength(List<String> results){
        return results.stream()
                .mapToInt(String::length)
                .max()
                .orElse(0);
    }

    private List<String> getNames(){
        boolean valid;
        List<String> splitNames;

        do {
            System.out.println("참여할 사람 이름을 입력하세요. (이름은 다섯글자 이하로 쉼표(,)로 구분하세요)");
            String names = sc.nextLine()
                            .replaceAll(" ", "");
            valid = checkNumOfElement(names);
            splitNames = new ArrayList<>(Arrays.asList(names.split(",")));
            valid = valid && checkNameLength(splitNames);
        }while(!valid);

        return splitNames;
    }

    private boolean checkNumOfElement(String input) {
        if (!input.contains(",")) {
            System.out.println("둘 이상 입력해주세요.");
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

    private List<String> getResults(int numOfPeople){
        boolean valid;
        List<String> splitResults;

        do{
            System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
            String results = sc.nextLine()
                    .replaceAll(" ", "");
            valid = checkNumOfElement(results);
            splitResults = new ArrayList<>(Arrays.asList(results.split(",")));
            valid = valid && checkNumOfPeople(numOfPeople, splitResults.size());
        }while(!valid);

        return splitResults;
    }

    private boolean checkNumOfPeople(int nameSize, int resultSize){
        if(nameSize == resultSize) { return true; }
        System.out.println(("사람 수와 결과의 수가 다릅니다. 결과를 " + nameSize + "개 입력해주세요."));
        return false;
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