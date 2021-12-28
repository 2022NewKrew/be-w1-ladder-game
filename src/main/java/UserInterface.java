import java.util.Scanner;

public class UserInterface {

    private Ladder ladder;
    private Scanner scanner;

    public UserInterface(Scanner scanner){
        this.scanner = scanner;
    }

    public void makeLadder(){
        int height, manCount;
        manCount = readInput(new InputCondition("참여할 사람은 몇 명 인가요?", 1, "2명 이상의 사람 수를 입력해주세요!"));
        height = readInput(new InputCondition("사다리의 최대 높이는 몇 개 인가요?", 0, "1 이상의 사다리 높이를 입력해주세요!"));
        ladder = Ladder.getInstance(height, manCount);
    }


    private int readInput(InputCondition inputCondition){
        int input;
        do {
            System.out.println(inputCondition.getQuery());
            input = scanner.nextInt();
        }while(!inputCondition.isValid(input));
        return input;
    }

    public void printLadder(){
        System.out.println(ladder.toString());
    }


}
