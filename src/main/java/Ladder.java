import java.util.Random;
import java.util.Scanner;

public class Ladder {

    public int numParticipants;
    public int height;
    public boolean[][] shape;

    public void getInput() {
        Scanner sc = new Scanner(System.in);

        System.out.println("참여할 사람은 몇 명인가요?");
        this.numParticipants = sc.nextInt();
        System.out.println("최대 사다리 높이는 얼마인가요?");
        this.height = sc.nextInt();
    }

    public void makeLadder() {
        this.shape = new boolean[this.height][this.numParticipants];
        Random random = new Random();

        for(int row = 0; row < this.height; row++) {
            for (int col = 0; col < this.numParticipants - 1; col++) {
                this.shape[row][col] = random.nextBoolean();
            }
        }
    }

    public void printLadder() {
        StringBuffer sb = new StringBuffer();

        for(int row = 0; row < this.height; row++) {
            sb.append("|");
            for (int col = 0; col < this.numParticipants - 1; col++) {
                if(this.shape[row][col]) sb.append(" ");
                else sb.append("-");
                sb.append("|");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

}
