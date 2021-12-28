import ladder.Ladder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {
    public static void main(String[] args) throws IOException {
        ApplicationInput input = getInput();
        Ladder ladder = new Ladder(input.people, input.height);
        System.out.println(ladder);
    }

    private static ApplicationInput getInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ApplicationInput input = new ApplicationInput();

        System.out.println("참여할 사람은 몇 명인가요?");
        input.people = Integer.parseInt(br.readLine());
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        input.height = Integer.parseInt(br.readLine());
        return input;
    }

    static class ApplicationInput {
        private int people;
        private int height;
    }
}
