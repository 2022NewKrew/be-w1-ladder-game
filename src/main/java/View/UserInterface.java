package View;

import Domain.*;

import java.util.*;

public class UserInterface {

    private static final String ALL_STRING = "all";
    private static final String END_STRING = "춘식이";
    private static final String BYE_STRING = "게임을 종료합니다.";

    private Scanner scanner;

    public UserInterface() {
        this.scanner = new Scanner(System.in);
    }

    public Input<ArrayList<String>> readPlayers() {
        Input<ArrayList<String>> playerInput = null;
        ArrayList<StrCond> playerConds = new ArrayList<>(Arrays.asList(new StrLstSizeGTECond(1), new LenLTStrCond(5)));
        StrInputCondition playerInputCond = new StrInputCondition("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)", playerConds, "2명 이상의 사람 수를 입력해주세요!");
        do {
            playerInput = new Input<>(playerInputCond);
            System.out.println(playerInputCond.getQuery());
            playerInput.setValue(new ArrayList<>(Arrays.asList(readStr().split(","))));
        } while (!isValid(playerInput));
        return playerInput;
    }

    public Input<Integer> readHeight() {
        Input<Integer> heightInput = null;
        IntInputCondition heightInputCond = new IntInputCondition("사다리의 최대 높이는 몇 개 인가요?", 0, "1 이상의 사다리 높이를 입력해주세요!");
        do {
            heightInput = new Input<>(heightInputCond);
            System.out.println(heightInputCond.getQuery());
            heightInput.setValue(readInt());
        } while (!isValid(heightInput));
        return heightInput;
    }

    public Input<ArrayList<String>> readResult(int len) {
        Input<ArrayList<String>> resultInput = null;
        ArrayList<StrCond> playerConds = new ArrayList<>(Arrays.asList(new StrLstSizeEqCond(len), new LenLTStrCond(5)));
        StrInputCondition playerInputCond = new StrInputCondition("실행 결과를 입력하세요.", playerConds, "사람 수에 맞게 결과를 입력하세요!");
        do {
            resultInput = new Input<>(playerInputCond);
            System.out.println(playerInputCond.getQuery());
            resultInput.setValue(new ArrayList<>(Arrays.asList(readStr().split(","))));
        } while (!isValid(resultInput));
        return resultInput;
    }

    public Input<ArrayList<String>> readQuery(){
        Input<ArrayList<String>> queryInput = null;
        NoneInputCondition queryInputCond = new NoneInputCondition("결과를 보고 싶은 사람은?");
        do{
            queryInput = new Input<>(queryInputCond);
            System.out.println(queryInputCond.getQuery());
            queryInput.setValue(new ArrayList<>(Arrays.asList(readStr().split(","))));
        }while(!isValid(queryInput));
        return queryInput;
    }

    private String readStr() {
        Input<String> target = new Input<>();
        while (!readStrInput(target)) ;
        return target.getValue();
    }

    private boolean readStrInput(Input target) {
        String input;
        try {
            input = scanner.next();
            target.setValue(input);
        } catch (InputMismatchException e) {
            System.out.println("문자열을 입력해주세요!");
            flush();
            return false;
        }
        return true;
    }

    private int readInt() {
        Input<Integer> target = new Input<>();
        while (!readIntInput(target)) ;
        return target.getValue();
    }


    private boolean readIntInput(Input target) {
        int input;
        try {
            input = scanner.nextInt();
            target.setValue(input);
        } catch (InputMismatchException e) {
            System.out.println("정수를 입력해주세요!");
            flush();
            return false;
        }
        return true;
    }

    private void flush() {
        scanner.nextLine();
    }

    private boolean isValid(Input input) {
        boolean res = input.isValid();
        if (res == false) System.out.println(input.getInputCondition().getErrorMsg());
        return res;
    }


    public void printLadder(Ladder ladder) {
        System.out.println(ladder.toString());
    }

    // 테스트용 임시함수
    public void printDst(Ladder ladder){
        ladder.printDst();
    }

    public void printPlayers(PlayerList playerList) {
        System.out.println(playerList.toString());
    }

    public void printResults(ResultList resultList) {
        System.out.println(resultList.toString());
    }

    public void printResultForQuery(ResultList resultList){
        ArrayList<Result> results = resultList.getResults();
        for(Result result : results)
            System.out.println(result);
    }

    public boolean isAll(String str){
        return ALL_STRING.equals(str);
    }

    public boolean isEnd(String str){
        return END_STRING.equals(str);
    }
    public void printBye(){
        System.out.println(BYE_STRING);
    }

    public void printAllPlayerAndResult(PlayerList queryPlayers, ResultList resultList){
        List<Result> resultStr = resultList.getResults();
        List<Player> players = queryPlayers.getPlayers();

        for(int i=0; i<players.size() && i < resultStr.size(); i++)
            System.out.printf("%s : %s\n", players.get(i).toString(), resultStr.get(i));
    }


}
