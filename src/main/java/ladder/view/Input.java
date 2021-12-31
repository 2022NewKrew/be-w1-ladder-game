package ladder.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public String input(String message) throws IOException {
        System.out.println(message);
        return bufferedReader.readLine();
    }
}
