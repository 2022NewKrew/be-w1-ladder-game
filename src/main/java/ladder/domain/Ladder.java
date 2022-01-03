package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {
    private static final String PILLAR = "|";
    private static final String BRIDGE = "-----";
    private static final String BLANK = "     ";
    private static final Random random = new Random();

    private int numOfPerson;
    private int height;
    private List<LadderRow> ladder;

    public Ladder(int numOfPerson, int height) throws IllegalArgumentException {
        if (numOfPerson <= 1 || height <= 0)
            throw new IllegalArgumentException();

        this.numOfPerson = numOfPerson;
        this.height = height;

        this.ladder = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            this.ladder.add(new Ladder.LadderRow(numOfPerson));
        }
    }

    public int travel(int startIdx){

        int currentIdx = startIdx;

        for(LadderRow row : this.ladder){
            currentIdx = row.travel(currentIdx);
        }
        return currentIdx;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (LadderRow row : this.ladder) {
            builder.append("  "); //왼쪽 패딩 2칸 공백
            builder.append(row);
            builder.append("\n");
        }

        return builder.toString();
    }


    //
    // 사다리의 한 행을 나타내는 이너클래스입니다.
    //
    private class LadderRow {


        private List<Boolean> points;

        public LadderRow(int numOfPerson) {
            this.points = new ArrayList<>(numOfPerson - 1);

            Boolean lastPoint = false;
            for (int i = 0; i < numOfPerson - 1; i++) {
                Boolean isAvailable = !lastPoint;
                Boolean newPoint = random.nextBoolean() && isAvailable;
                this.points.add(newPoint);
                lastPoint = newPoint;
            }

            if (!isValidRow())
                throw new RuntimeException();

        }

        //
        // 인접한 다리가 있는지 한 번 더 검사하는 코드입니다.
        //
        public Boolean isValidRow(){
            Boolean prevPoint = false;
            for(Boolean currentPoint : this.points){
                if (currentPoint && prevPoint){
                    return false;
                }
                prevPoint = currentPoint;
            }
            return true;
        }

        public int travel(int fromIdx){
            if (fromIdx > 0 && this.points.get(fromIdx-1))
                return fromIdx - 1;
            if (fromIdx < numOfPerson-1 && this.points.get(fromIdx))
                return fromIdx + 1;
            return fromIdx;
        }


        public String toString() {
            StringBuilder builder = new StringBuilder();

            builder.append(PILLAR);
            for (Boolean point : this.points) {
                builder.append(point ? BRIDGE : BLANK);
                builder.append(PILLAR);
            }

            return builder.toString();
        }

    }

}

