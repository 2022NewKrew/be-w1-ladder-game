import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CUI {
    private final List<String> parts = new ArrayList<>();
    int height;

    /**
     * scanner 를 사용하여 input 처리
     *
     * @return [참여자수, 사다리 높이]
     */
    public int[] input() {
        int[] inputs = new int[2];
        Scanner sc = new Scanner(System.in);
        System.out.println("참여할 사람은 몇 명인가요?");
        inputs[0] = sc.nextInt();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        inputs[1] = sc.nextInt();
        return inputs;
    }

}
