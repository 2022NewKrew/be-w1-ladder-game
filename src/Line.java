import java.util.*;

public class Line {
    static Random random = new Random();
    private final ArrayList<Boolean> bridges = new ArrayList<>();
    private static final int MAX_NAME_LENGTH = 5;

    Line (int countOfPerson) {
        bridges.add(random.nextBoolean());
        for (int cnt = 1; cnt < countOfPerson; cnt++) {
            bridges.add(!bridges.get(cnt-1) && random.nextBoolean());
        }
    }
    void printBridges(int bridgeIndex) {
        String bridge = bridges.get(bridgeIndex) ? "-" : " ";
        bridge = bridge.repeat(MAX_NAME_LENGTH);
        System.out.print(bridge);
    }

    void printLine(int countOfPerson) {
        System.out.print("|");
        for(int cnt = 0; cnt < countOfPerson - 1; cnt ++) {
            printBridges(cnt);
            System.out.print('|');
        }
        System.out.println();
    }
}
