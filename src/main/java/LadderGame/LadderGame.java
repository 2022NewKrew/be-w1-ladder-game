package LadderGame;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class LadderGame {
    private static Random random = new Random();

    private int n;
    private int m;
    private ArrayList<LadderRow> ladder;

    public LadderGame(int n, int m){
        if (n <= 0 || m <= 0)
            throw new IllegalArgumentException();

        this.n = n;
        this.m = m;
        ladder = new ArrayList<LadderRow>();
        random.setSeed(System.currentTimeMillis());

        for(int i = 0; i < m; i++){
            ladder.add(new LadderRow(n));
        }
    }

    public void printLadder(){
        for(int i = 0; i < m; i++){
            System.out.println(ladder.get(i));
        }
    }

    class LadderRow{
        private final String DELIMITER = "|";

        private ArrayList<String> row;

        public LadderRow(int n){
            row = new ArrayList<String>(n-1);
            for(int i=0; i<n-1; i++){
                row.add(random.nextBoolean() == true ? "-" : " ");
            }
        }

        public String toString(){
            String result = DELIMITER + String.join(DELIMITER, row) + DELIMITER;
            return result;
        }
    }



    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("참여할 사람은 몇 명인가요?");
        int n = sc.nextInt();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int m = sc.nextInt();

        try{
            LadderGame ladder = new LadderGame(n,m);
            ladder.printLadder();
        }catch(IllegalArgumentException e){
            System.err.println(e);
        }

    }

}

