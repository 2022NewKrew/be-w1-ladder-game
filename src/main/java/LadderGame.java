import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class LadderGame {

    // 0: 기둥, 1: 다리, 2: 공백
    private static String[] STRINGS = {"|", "-", " "};
    private static Random rd = new Random();

    public static void main(String[] args) {

        // 입력 받기
        int[] heightAndPeople = inputHeightAndPeople();
        int people = heightAndPeople[0];
        int height = heightAndPeople[1];

        // 사다리 만들기
        String[][] ladder = createLadder(people, height);

        // 출력
        StringBuilder ladderStringBuilder = ladderToString(ladder);
        System.out.println(ladderStringBuilder);
    }

    private static int[] inputHeightAndPeople(){
        try(Scanner sc = new Scanner(System.in)) {
            System.out.println("참여할 사람은 몇 명인가요?");
            int people = sc.nextInt();
            System.out.println("최대 사다리 높이는 몇 개인가요?");
            int height = sc.nextInt();
            int[] rtn = {people, height};

            return rtn;
        }
    }

    // 랜덤 Boolean 반환
    private static boolean randomBoolean(Random rd){
        return rd.nextBoolean();
    }

    private static String[][] createLadder(int people, int height){
        String[][] ladder = new String[height][(people-1)*2 +1];
        for (int i = 0; i < height; i++){
            for (int j = 0 ; j < (people-1)*2 + 1; j++) {
                if (j % 2 == 0) ladder[i][j] = STRINGS[0];
                else ladder[i][j] = randomBoolean(rd) ? STRINGS[1] : STRINGS[2];
            }
        }
        return ladder;
    }

    private static StringBuilder ladderToString(String[][] array){
        StringBuilder sb = new StringBuilder();
        for(String[] innerArray : array){
            for(String st : innerArray){
                sb.append(st);
            }
            sb.append('\n');
        }
        return sb;
    }
}
