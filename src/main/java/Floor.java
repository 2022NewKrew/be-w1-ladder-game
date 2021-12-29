import java.util.ArrayList;
import java.util.List;

public class Floor {
    public static final String H_BAR = "-";
    public static final String SPACE = " ";
    public static final String V_BAR = "|";
    public static final int REPEAT_COUNT = 5;
    private final List<String> floorList = new ArrayList<>();

    public void printFloor() {
        for (String ladder : floorList) {
            System.out.print(ladder);
        }
    }

    private boolean hasVBar(int part) {
        return getBarValue(part).equals(H_BAR);
    }

    private String getBarValue(int part) {
        return floorList.get(part * 2 - 1);
    }

    public boolean hasLeftBar(int part) {
        if (part > 0) {
            return hasVBar(part);
        }
        return false;
    }

    /**
     * 난수 생성하여 연결된 가로 사다리"-", 또는 빈 사다리" " 리턴
     */
    static String getRandomLadder() {
        double dValue = Math.random();
        int randomValue = (int) (dValue * 2);
        if (randomValue == 0) {
            return SPACE;
        }
        return H_BAR;
    }

    /**
     * floorList 에 사다리 String Value 추가(" ","|", " ")
     *
     * @param part    참여자 index
     * @param partNum 총 참여자 수
     */
    void addLadderString(int part, int partNum) {
        floorList.add(V_BAR);
        if (hasLeftBar(part)) {
            floorList.add(SPACE.repeat(REPEAT_COUNT));
            return;
        }
        if (part != partNum - 1)
            floorList.add(getRandomLadder().repeat(REPEAT_COUNT));
    }


}