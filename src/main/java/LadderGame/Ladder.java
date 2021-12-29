package LadderGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Ladder {
    private static final String PILLAR = "|";
    private static final String BRIDGE = "-----";
    private static final String BLANK = "     ";

    private int numOfPerson;
    private int height;
    private ArrayList<LadderRow> ladder;
    private List<String> personNames;

    public Ladder(List<String> personNames, int height) {
        if (personNames.isEmpty() || height <= 0)
            throw new IllegalArgumentException();

        this.personNames = personNames;
        this.numOfPerson = personNames.size();
        this.height = height;

        ladder = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            ladder.add(new Ladder.LadderRow(numOfPerson));
        }
    }


    //
    // Row를 한 줄씩 가져와 화면에 출력합니다.
    //
    public void printLadder() {
        StringBuilder builder = new StringBuilder();
        for (String personName : personNames){
            try {
                builder.append(centerAligned(personName, 5));
                builder.append(" ");
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        builder.append("\n");
        for (LadderRow row : ladder) {
            builder.append("  "); //왼쪽 패딩 2칸 공백
            builder.append(row);
            builder.append("\n");
        }

        System.out.println(builder.toString());
    }

    //
    // 입력 문자를 size에 맞게 가운데 정렬합니다. 예시는 아래와 같습니다. (_:공백)
    // 1글자,size=5 -> __a__
    // 2글자,size=5 -> _aa__
    // 3글자,size=5 -> _aaa_
    // 4글자,size=5 -> aaaa_
    private String centerAligned(String str, int size){

        if(str.isEmpty() || str.isBlank()) {
            return null;
        }

        int leftPad = (int)((size - str.length()) / 2);

        if (leftPad == 0){
            return String.format("%"+(-size)+"s", str);
        }

        return String.format(
                "%" + (-size) + "s",
                String.format("%" + (leftPad+str.length()) + "s", str)
                );
    }


    //
    // 사다리의 한 행을 나타내는 이너클래스입니다.
    //
    class LadderRow {

        private ArrayList<Boolean> points;

        public LadderRow(int numOfPerson) {
            Random random = new Random();
            points = new ArrayList<Boolean>(numOfPerson - 1);

            Boolean lastPoint = false;
            for (int i = 0; i < numOfPerson - 1; i++) {
                lastPoint = random.nextBoolean() && (!lastPoint);
                points.add(lastPoint);
            }
        }

        //
        // 외부 클래스의 지정된 문자를 가져와 현재 row 상태를 문자열로 반환합니다.
        //
        public String toString() {
            StringBuilder builder = new StringBuilder();

            builder.append(PILLAR);
            for (Boolean point : points) {
                builder.append(point ? BRIDGE : BLANK);
                builder.append(PILLAR);
            }

            return builder.toString();
        }

    }

}

