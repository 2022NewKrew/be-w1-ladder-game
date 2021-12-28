import java.util.Scanner;

public class InputView {

    private static final Scanner sc = new Scanner(System.in);

    public static int askNumOfPeople() {
        System.out.println("참여할 사람은 몇 명인가요?");
        return sc.nextInt();
    }

    public static int askHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return sc.nextInt();
    }

}
