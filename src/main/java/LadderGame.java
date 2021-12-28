import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class LadderGame {

    int n;
    int m;
    int width;
    int height;
    char[][] ladder;
    Random random;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("참여할 사람은 몇 명인가요?");
        int n = sc.nextInt();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int m = sc.nextInt();

        LadderGame ladder = new LadderGame(n,m);
        ladder.fillLadder();
        ladder.printLadder();
    }

    public LadderGame(int n, int m){
        this.n = n;
        this.m = m;
        width = 2 * n - 1;
        height = m;
        ladder = new char[height][width];
        random = new Random();
        random.setSeed(System.currentTimeMillis());
    }

    public void fillLadder(){
        for(int i=0; i < height; i++){
            for(int j=0; j < width; j++){
                if(j % 2 == 0)
                    ladder[i][j] = '|';
                else
                    ladder[i][j] = random.nextBoolean() == true ? '-' : ' ';
            }
        }
    }

    public void printLadder(){
        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                System.out.print(ladder[i][j]);
            }
            System.out.println();
        }
    }

}

