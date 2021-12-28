import ladder.Ladder;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        ApplicationInput input = new ApplicationInput();
        Ladder ladder = new Ladder(input.getPeople(), input.getHeight());
        System.out.println(ladder);
    }
}
