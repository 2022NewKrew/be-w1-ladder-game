import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LadderGame {
    public static void main(String[] args) throws IOException {
        int[] twoParameters = getConsoleTwoParameter();

        Ladder ladder = new Ladder(twoParameters);
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
