import java.util.*;

public class UserInterface {

    private Ladder ladder;
    private Scanner scanner;

    public UserInterface(Scanner scanner) {
        this.scanner = scanner;
    }

    public void makeLadder() {
        List<String> players;
        int height;
        //manCount = readIntInput(new IntInputCondition("참여할 사람은 몇 명 인가요?", 1, "2명 이상의 사람 수를 입력해주세요!"));
        ArrayList<StrCond> playerConds = new ArrayList<>(Arrays.asList(new LstSizeStrCond(1), new LenLTStrCond(5)));
        players = readStrInput(new StrInputCondition("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요.", playerConds, "2명 이상의 사람 수를 입력해주세요!"));
        height = readIntInput(new IntInputCondition("사다리의 최대 높이는 몇 개 인가요?", 0, "1 이상의 사다리 높이를 입력해주세요!"));
        ladder = Ladder.getInstance(height, players.size());
    }



    private List<String> readStrInput(StrInputCondition strInputCondition){
        List<String> input = null;
        do{
            System.out.println(strInputCondition.getQuery());
            input = Arrays.asList(readStr().split(","));
        }while(!isValid(new Input<List<String>>(input), strInputCondition));
        return input;
    }

    private String readStr(){
        Input<String> target = new Input<>();
        while(!setStrInput(target));
        return target.getValue();
    }

    private boolean setStrInput(Input target){
        String input;
        try{
            input = scanner.next();
            target.setValue(input);
        }catch (InputMismatchException e){
            System.out.println("문자열을 입력해주세요!");
            flush();
            return false;
        }
        return true;
    }

    private int readIntInput(IntInputCondition inputCondition) {
        int input;
        do {
            System.out.println(inputCondition.getQuery());
            input = readInt();
        } while (!isValid(new Input<Integer>(input), inputCondition));
        return input;
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

    private boolean isValid(Input input, InputCondition inputCondition) {
        boolean res = inputCondition.isValid(input);
        if (res == false) System.out.println(inputCondition.getErrorMsg());
        return res;
    }

    public void printLadder() {
        System.out.println(ladder.toString());
    }


}
