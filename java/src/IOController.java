import java.util.Scanner;

public class IOController {
    private static final Scanner sc = new Scanner(System.in);

    public int inputInt(String msg) {
        System.out.println(msg);
        return sc.nextInt();
    }

    public String inputString(String msg) {
        System.out.println(msg);
        return sc.nextLine();
    }
}
