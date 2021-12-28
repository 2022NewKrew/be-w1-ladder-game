import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private ArrayList<String> users;
    private Ladder ladder;
    private Scanner sc = new Scanner(System.in);

    private ArrayList<String> inputUsers(){
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String input = sc.nextLine();
        ArrayList<String> arraylist = new ArrayList<String>();
        for (String name : input.split(",")){
            arraylist.add(Util.resizeString(name, 5));
        };
        return arraylist;
    }

    private int inputLadderHeight(){
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = sc.nextInt();
        return height;
    }

    private void printGame(){
        for (String name : users){
            System.out.print(String.format("%5s",name));
            System.out.print(" ");
        };
        System.out.println();
        ladder.printLadder();
    }

    public void init(){
        users = inputUsers();
        ladder = new Ladder(users.size(), inputLadderHeight());
        printGame();
    }
}
