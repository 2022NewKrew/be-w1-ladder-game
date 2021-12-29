package ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.stream.IntStream;

//사다리 정보
public class LadderInfo {
    private List<List<Bridge>> ladder; //실질적인 사다리를 나타내는 컬렉션

    //높이,너비 데이터 바탕으로 생성하는 생성자
    public LadderInfo(int height, int playerCnt) {
        ladder = new ArrayList<>(height);
        int rowSize = calRowSize(playerCnt);

        for (int i = 0; i < height; i++) {
            ladder.add(new ArrayList<>(rowSize));
        }

        Consumer<List<Bridge>> construct = b -> b.add(Bridge.EMPTY);
        constructList(ladder, construct, rowSize);
    }

    //2d list 초기화를 돕기위한 메소드
    private <T> void constructList(List<T> list, Consumer<T> construct, int rowSize) {
        list.stream().forEach(b ->
        {
            for (int i = 0; i < rowSize; i++) {
                construct.accept(b);
            }
        });
    }

    //너비 사이즈 계산
    private int calRowSize(int playerCnt) {
        return playerCnt * 2 - 1;
    }

    //사다리 높이 반환
    public int getHeight() {
        return ladder.size();
    }

    //사다리 너비 반환
    public int getWidth() {
        return ladder.get(0).size();
    }

    //랜덤함수의 bound 계산
    private int getTotalBound() {
        return (getWidth() - 1) * getHeight() / 2;
    }

    //사다리 초기화
    public void initLadder() {
        for (List<Bridge> row : ladder) {
            IntStream.range(0, row.size())
                    .filter(i -> i % 2 == 0)
                    .forEach(i -> row.set(i, Bridge.DEFAULT));
        }
    }

    //홀수번째 인덱스 계산
    public int getOddIdx(int col) {
        return col * 2 + 1;
    }

    //플레이어 수 계산
    public int getPlayerCnt() {
        return (getWidth() + 1) / 2;
    }

    //랜덤으로 사다리 가로정보 추가
    public void insertBridgeInfo() {
        Random random = new Random();
        int total = random.nextInt(getTotalBound());

        for (int i = 0; i < total; i++) {
            int col = random.nextInt(getPlayerCnt() - 1);
            int row = random.nextInt(getHeight());

            ladder.get(row).set(getOddIdx(col), Bridge.EXIST);
        }
    }

    public List<List<Bridge>> getLadder() {
        return ladder;
    }
}
