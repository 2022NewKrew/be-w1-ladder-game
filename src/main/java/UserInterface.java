import java.util.*;

public class UserInterface {

    private Scanner scanner;

    public UserInterface() {
        this.scanner = new Scanner(System.in);
    }

    public Input<ArrayList<String>> readPlayers() {
        Input<ArrayList<String>> playerInput = null;
        ArrayList<StrCond> playerConds = new ArrayList<>(Arrays.asList(new LstSizeStrCond(1), new LenLTStrCond(5)));
        StrInputCondition playerInputCond = new StrInputCondition("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요.", playerConds, "2명 이상의 사람 수를 입력해주세요!");
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


    private String readStr() {
        Input<String> target = new Input<>();
        while (!setStrInput(target)) ;
        return target.getValue();
    }

    private boolean setStrInput(Input target) {
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
        while (!setIntInput(target)) ;
        return target.getValue();
    }


    private boolean setIntInput(Input target) {
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

    public void printPlayers(PlayerList playerList) {
        System.out.println(playerList.toString());
    }

}
