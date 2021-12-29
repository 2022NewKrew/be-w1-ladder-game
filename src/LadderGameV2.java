import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LadderGameV2 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int people, height;

        System.out.println("참여할 사람은 몇 명 인가요?");
        people = Integer.parseInt(in.readLine());
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        height = Integer.parseInt(in.readLine());

        Ladder ladder = new Ladder(people, height);
        ladder.createLadder();

        System.out.println(ladder.printLadder());
    }
}
