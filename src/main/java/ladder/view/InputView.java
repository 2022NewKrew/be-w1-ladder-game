package ladder.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private InputView() {
    }

    public static int inputCountOfPerson() throws IOException {
        System.out.println("참여할 사람은 몇 명인가요?");
        return Integer.parseInt(br.readLine());
    }

    public static int inputLadderHeight() throws IOException {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int ladderHeight = Integer.parseInt(br.readLine());
        System.out.println();

        return ladderHeight;
    }

}
