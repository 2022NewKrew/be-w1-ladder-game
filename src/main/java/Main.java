import java.util.ArrayList;
import java.util.List;

public class Main {

    /**
     * ladderList 에 각 층별로 floorList 추가
     *
     * @param partNum    총 참여자 수
     * @param ladderList 사다리 List
     */
    static void addFloorList(int partNum, List<Floor> ladderList) {
        Floor floor = new Floor();
        for (int part = 0; part < partNum; part++) {
            floor.addLadderString(part, partNum);
        }
        ladderList.add(floor);
    }

    /**
     * 사다리 정보 배열 출력을 위한 Ladder Array List 생성
     *
     * @param inputs 참여자수, 사다리 높이 정보
     * @return ladderList
     */
    static List<Floor> makeLadderList(int[] inputs) {
        int partNum = inputs[0]; // 참여자 수
        int floorNum = inputs[1]; // 층수
        List<Floor> ladderList = new ArrayList<>();
        for (int i = 0; i < floorNum; i++) {
            addFloorList(partNum, ladderList);
        }
        return ladderList;
    }


    /**
     * ladderList 를 모양에 맞게 출력
     *
     * @param ladderList 사다리 List
     */
    static void printLadder(List<Floor> ladderList) {
        for (Floor floor : ladderList) {
            floor.printFloor();
            System.out.println();
        }
    }

    public static void main(String[] args) {
        CUI cui = new CUI();
        List<Floor> ladderList = makeLadderList(cui.input());
        printLadder(ladderList);
    }

}
