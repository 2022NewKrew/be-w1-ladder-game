import java.util.ArrayList;
import java.util.List;

public class Ladder {
    public static final String UI_SPACE = " ";
    private final List<Floor> ladderList = new ArrayList<>();
    int partNum;
    int floorNum;

    /**
     * Generator
     * 사다리 정보 배열 출력을 위한 Ladder Array List 생성
     *
     * @param inputs 참여자수, 사다리 높이 정보
     */
    Ladder(int[] inputs) {
        partNum = inputs[0]; // 참여자 수
        floorNum = inputs[1]; // 층수
        for (int i = 0; i < floorNum; i++) {
            this.addFloorList();
        }
    }

    /**
     * ladderList 에 각 층별로 floorList 추가
     */
    private void addFloorList() {
        Floor floor = new Floor();
        for (int part = 0; part < partNum; part++) {
            floor.addLadderString(part, partNum);
        }
        ladderList.add(floor);
    }

    /**
     * ladderList 를 모양에 맞게 출력
     */
    public void printLadder() {
        for (Floor floor : ladderList) {
            System.out.print(UI_SPACE); // for UI
            floor.printFloor();
            System.out.println();
        }
    }
}
