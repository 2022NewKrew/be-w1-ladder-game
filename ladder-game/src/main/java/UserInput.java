import java.util.Scanner;

public class UserInput {
    static private final Scanner scanner = new Scanner(System.in);

    static public int getNumberOfPeople(){
        System.out.println("참여할 사람은 몇 명 인가요 ?");
        return scanner.nextInt();
    }

    static public int getLadderHeight(){
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }
}
