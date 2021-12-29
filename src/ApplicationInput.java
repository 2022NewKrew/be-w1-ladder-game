import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ApplicationInput {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private final int people;
    private final int height;

    public ApplicationInput() throws IOException {
        people = inputIntValue("참여할 사람은 몇 명인가요?");
        height = inputIntValue("최대 사다리 높이는 몇 개인가요?");
        br.close();
    }

    private int inputIntValue(String expression) throws IOException {
        System.out.println(expression);
        return Integer.parseInt(br.readLine());
    }

    public int getPeople() {
        return people;
    }

    public int getHeight() {
        return height;
    }
}
