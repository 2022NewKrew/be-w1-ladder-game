package LadderGame;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Ladder {
    private static Random random = new Random();
    private static final String PILLAR = "|";
    private static final String BRIDGE = "-";
    private static final String BLANK = " ";

    private int n;
    private int m;
    private ArrayList<LadderRow> ladder;

    public Ladder(){
        ladder = new ArrayList<LadderRow>();
        random.setSeed(System.currentTimeMillis());
    }

    //
    // n과 m을 입력받아 사다리를 생성합니다.
    //
    public void createLadder(){
        Scanner sc = new Scanner(System.in);
        System.out.println("참여할 사람은 몇 명인가요?");
        int n = sc.nextInt();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int m = sc.nextInt();

        if (n <= 0 || m <= 0)
            throw new IllegalArgumentException();

        this.n = n;
        this.m = m;

        for(int i = 0; i < m; i++){
            ladder.add(new LadderRow(n));
        }
    }

    //
    // Row를 한 줄씩 가져와 화면에 출력합니다.
    //
    public void printLadder(){
        StringBuilder builder = new StringBuilder();

        for(int i = 0; i < m; i++){
            builder.append(ladder.get(i));
            builder.append("\n");
        }
        System.out.println(builder.toString());
    }

    //
    // 사다리의 한 행을 나타내는 이너클래스입니다.
    //
    class LadderRow{

        private ArrayList<Boolean> row;

        public LadderRow(int n){
            row = new ArrayList<Boolean>(n-1);
            for(int i=0; i<n-1; i++){
                row.add(random.nextBoolean());
            }
        }

        //
        // 외부 클래스의 지정된 문자를 가져와 현재 row 상태를 문자열로 변환합니다.
        //
        public String toString(){
            StringBuilder builder = new StringBuilder();
            builder.append(PILLAR);
            for(int i=0; i<n-1; i++){
                builder.append(row.get(i) == true? BRIDGE : BLANK);
                builder.append(PILLAR);
            }
            return builder.toString();
        }

    }

}

