import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LadderV1 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int people, height;

        System.out.println("참여할 사람은 몇 명 인가요?");
        people = Integer.parseInt(in.readLine());
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        height = Integer.parseInt(in.readLine());

        createLadder(people, height);
    }

    public static void createLadder(int people, int height){
        char[][] ladder = new char[height][people-1];

        for(int i=0; i<height; i++){
            for(int j=0; j<people-1; j++){
                ladder[i][j] = (int)(Math.random() * 2) == 0 ? ' ' : '-';
                if(j > 0 && (ladder[i][j-1] == '-') && (ladder[i][j-1] == ladder[i][j]))
                    ladder[i][j-(int)(Math.random() * 2)] = ' ';
            }
        }
        printLadder(ladder, people, height);
    }

    public static void printLadder(char[][] ladder, int people, int height){
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<height; i++){
            sb.append("|");
            for(int j=0; j<people-1; j++){
                sb.append(ladder[i][j]).append("|");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

}
