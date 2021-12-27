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
        StringBuilder ladder = createLadder(people, height);

        // 출력
        System.out.println(ladder);
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

    private static StringBuilder createLadder(int people, int height){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < height; i++){
            for (int j = 0 ; j < (people-1)*2 + 1; j++) {
                if (j % 2 == 0) sb.append(STRINGS[0]);
                else sb.append(randomBoolean(rd) ? STRINGS[1] : STRINGS[2]);
            }
            sb.append('\n');
        }
        return sb;
    }
}
