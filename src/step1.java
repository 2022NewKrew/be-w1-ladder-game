import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class step1 {
    public static void main(String[] args) throws IOException {
        //1. Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("참여할 사람은 몇 명인가요?");
        int n = Integer.parseInt(br.readLine());
        System.out.println("사다리 높이는 몇 개인가요?");
        int h = Integer.parseInt(br.readLine());

        //2. Make Ladders
        ArrayList<ArrayList<String>> ladders = makeLadders(n, h);

        //3. Print Result
        ladders.stream()
                .map(s -> String.join("", s))
                .forEach(System.out::println);
    }

    private static ArrayList<ArrayList<String>> makeLadders(int n, int h) {
        ArrayList<ArrayList<String>> ladders = new ArrayList<>();
        for (int i = 0; i< h; i++) {
            ladders.add(getLadder(n));
        }
        return ladders;
    }

    private static ArrayList<String> getLadder(int n) {
        ArrayList<String> ladder = new ArrayList<>();
        for (int j = 0; j < 2 * n - 1; j++) {
            ladder.add(makeLadder(j));
        }
        return ladder;
    }

    private static String makeLadder(int j) {
        if (j % 2 == 0) {
            return "|";
        } else {
            return Math.random() > 0.5 ? " " : "-";
        }
    }
}
