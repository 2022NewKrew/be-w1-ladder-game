import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LadderGame {

    // 클래스 변수
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String names = getConsoleNameList();
        int ladderHeight = getConsoleLadderHeight();
        scanner.close();

        Ladder ladder = new Ladder(names, ladderHeight);

        System.out.println(ladder);
    }

    private static int[] getConsoleTwoParameter() throws IOException {
        int[] twoParameters = new int[2];
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("참여할 사람은 몇 명인가요 ?");
        twoParameters[0] = Integer.parseInt(bufferedReader.readLine());
        System.out.println("최대 사다리 높이는 몇 개인가요 ?");
        twoParameters[1] = Integer.parseInt(bufferedReader.readLine());
        bufferedReader.close();

        return twoParameters;
    }
}
