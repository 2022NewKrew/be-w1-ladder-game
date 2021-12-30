import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Input {

    private static final Scanner sc = new Scanner(System.in);
    private static final String SPLIT_REGEX = ",";

    private Input() {}

    public static ArrayList<String> getPlayerNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return new ArrayList<>(Arrays.asList(sc.nextLine().split(SPLIT_REGEX)));
    }

    public static int getLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return sc.nextInt();
    }
}