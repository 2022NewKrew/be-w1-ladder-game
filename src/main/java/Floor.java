import java.util.ArrayList;

public class Floor {
    private ArrayList<String> floorList = new ArrayList<>();

    public void printFloor(){
        for (String ladder:floorList) {
            System.out.print(ladder);
        }
    }

    public ArrayList<String> getFloorList() {
        return floorList;
    }

    public boolean checkSide(int countOfPerson) {
        // TODO: 라인의 좌표 값에 선이 있는지 유무를 판단하는 로직 추가
        return true;
    }

    /**
     * 난수 생성하여 연결된 가로 사다리"-", 또는 빈 사다리" " 리턴
     */
    static String getRandomLadder(){
        double dValue = Math.random();
        int randomValue = (int)(dValue * 2);
        if(randomValue==0){
            return " ";
        }
        return "-";
    }

    /**
     * floorList 에 사다리 String Value 추가(" ","|", " ")
     * @param part 참여자 index
     * @param partNum 총 참여자 수
     */
    void addLadderString(int part, int partNum){
        floorList.add("|");
        if(part != partNum-1)
            floorList.add(getRandomLadder());
    }

}