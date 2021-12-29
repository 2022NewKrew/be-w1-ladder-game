import org.apache.commons.lang3.StringUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private List<String> users;
    private Ladder ladder;
    private Scanner sc = new Scanner(System.in);

    private List<String> inputUsers(){
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String input = sc.nextLine();
        List<String> inputUsers = new ArrayList<String>();
        for (String name : input.split(",")){
            inputUsers.add(StringUtils.substring(name, 0, 5));
        };
        return inputUsers;
    }

    private int inputLadderHeight(){
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return sc.nextInt();
    }

    private void print(){
        for (String name : users){
            System.out.print(String.format("%5s",name));
            System.out.print(" ");
        };
        System.out.println();
        ladder.print();
    }

    public void start(){
        users = inputUsers();
        ladder = new Ladder(users.size(), inputLadderHeight());
        print();
    }
}
