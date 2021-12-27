import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

//사다리 정보
public class Ladder {
    private int height = 0; //높이
    private Player player = null; //게임 플레이어
    private char ladder[][] = null;

    //사다리 높이와 플레이어 수 입력
    private void inputData() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("참여할 사람은 몇 명인가요?");
        player = new Player(scanner.nextInt());

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        this.height = scanner.nextInt();
    }

    //사다리 만들기
    public void makeLadder() {
        inputData();

        ladder = new char[this.height][this.player.getTotalNum()*2-1];
        Arrays.stream(ladder).forEach(l -> Arrays.fill(l, ' '));

        for(int i=0 ; i<ladder.length ; i++)
            for(int j=0 ; j<ladder[i].length ; j+=2)
                ladder[i][j] = '|';

        insertCrossInfo();
    }

    //랜덤으로 사다리 가로정보 추가
    private void insertCrossInfo() {
        Random random = new Random();
        int total = random.nextInt((player.getTotalNum()-1)*this.height/2);

        for(int i=0 ; i<total ; i++) {
            int col = random.nextInt(player.getTotalNum()-1)+1;
            int row = random.nextInt(this.height);

            ladder[row][col*2-1] = '-';
        }
    }

    //사다리 정보 출력
    public void printLadder() {
        for(int i=0 ; i<ladder.length ; i++) {
            for(int j=0 ; j<ladder[i].length ; j++) {
                System.out.print(ladder[i][j]);
            }
            System.out.println("\n");
        }
    }
}
