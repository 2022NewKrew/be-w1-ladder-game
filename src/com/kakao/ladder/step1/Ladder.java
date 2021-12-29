package step1;

import java.util.ArrayList;
import java.util.Scanner;

public class Ladder {
    public static ArrayList<String> makeLadder(int people, int height) {
        ArrayList<String> sadari = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        double randNum;
        for(int i=0;i<height;i++) {
            sb.setLength(0);
            for(int j=1;j<people;j++) {
                sb.append('|');
                // 0 ~ 1 사이의 난수를 가지고 0.5보다 크다면 공백, 0.5보다 작다면 -를 넣는다
                randNum = Math.random();
                if(randNum >= 0.5)
                    sb.append(' ');
                else
                    sb.append('-');
            }
            sb.append('|');
            sadari.add(sb.toString());
        }
        return sadari;
    }

    public static void printLadder(ArrayList<String> sadari) {
        for(String s : sadari) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int people, height;

        System.out.println("참여할 사람은 몇 명인가요?");
        people = s.nextInt();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        height = s.nextInt();

        ArrayList<String> sadari = makeLadder(people, height);
        printLadder(sadari);
    }
}
