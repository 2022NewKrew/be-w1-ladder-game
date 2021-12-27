import java.security.SecureRandom;
import java.util.ArrayList;

public class LadderData {
    private final ArrayList<String> bridges = new ArrayList<>();
    private final SecureRandom sRand = new SecureRandom();

    public void build(final InputParameter iPara) {
        bridges.clear();

        final int member = iPara.getMember();
        final int bound = 1 << (member - 1);
        final int height = iPara.getLadderHeight();

        for (int i = 0; i < height; i++) {
            // bound를 추가로 더해서
            // 사다리를 놓을 수 있는 최대 개수 + 1 위치에 1을 항상 추가하여
            // Zero-fill 처리하고 가장 위쪽 1을 잘라낸 뒤 저장한다
            final String bridge = Integer.toBinaryString(bound + sRand.nextInt(bound));
            bridges.add(bridge.substring(1));
        }
    }

    public void print() {
        for (String bridge : bridges) {
            printOneHeight(bridge);
        }
    }

    private void printOneHeight(final String bridge) {
        for (char ch : bridge.toCharArray()) {
            System.out.print("|" + (ch == '1' ? "-" : " "));
        }
        System.out.println("|");
    }
}
