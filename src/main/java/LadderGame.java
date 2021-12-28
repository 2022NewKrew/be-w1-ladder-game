import java.util.Random;
import java.util.Scanner;

public class LadderGame {

    private static Random rd = new Random();

    public static void main(String[] args) {

        // 입력 받기
        Ladder ladder = inputHeightAndPeople();

        // 사다리 만들기
        String[][] ladderShape = createLadder(ladder.getPeople(), ladder.getHeight());

        // 출력
        String ladderString = ladderToString(ladderShape);
        System.out.println(ladderString);
    }

    private static Ladder inputHeightAndPeople(){
        try(Scanner sc = new Scanner(System.in)) {
            System.out.println("참여할 사람은 몇 명인가요?");
            int people = sc.nextInt();
            System.out.println("최대 사다리 높이는 몇 개인가요?");
            int height = sc.nextInt();
            int[] rtn = {people, height};

            return new Ladder(people, height);
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
                if (j % 2 == 0) ladder[i][j] = StuffType.COLUMN.getStuff();
                else ladder[i][j] = randomBoolean(rd) ? StuffType.BRIDGE.getStuff() : StuffType.SPACE.getStuff();
            }
        }
        return ladder;
    }

    private static String ladderToString(String[][] array){
        StringBuilder sb = new StringBuilder();
        for(String[] innerArray : array){
            for(String st : innerArray){
                sb.append(st);
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
