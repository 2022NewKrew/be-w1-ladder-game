import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LadderGameV3 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String userNames;
        int height;

        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        userNames = in.readLine();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        height = Integer.parseInt(in.readLine());

        LadderManager lm = new LadderManager(userNames, height);
        lm.startLadder();
    }
}
