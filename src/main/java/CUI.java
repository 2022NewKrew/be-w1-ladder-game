import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CUI {
    public static final String NAME_FORMAT_NUM = "%-6s";
    private final Scanner sc = new Scanner(System.in);
    private final List<String> parts = new ArrayList<>();

    /**
     * scanner 를 사용하여 input 처리
     *
     * @return [참여자수, 사다리 높이]
     */
    public int[] input() {
        int[] inputs = new int[2];
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        inputs[0] = inputNames();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        inputs[1] = sc.nextInt();
        return inputs;
    }

    private int inputNames(){
        String input = sc.next();
        parts.addAll(List.of(input.split(",")));
        return parts.size();
    }
    public void printNames(){
        for (String part:parts) {
            System.out.printf(NAME_FORMAT_NUM,part);
        }
        System.out.println();
    }

}
