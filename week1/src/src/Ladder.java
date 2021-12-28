import java.util.Random;
import java.util.Scanner;

public class Ladder {
    private int[][] map;
    private int peopleNum;
    private int height;

    Ladder(){
        Scanner sc = new Scanner(System.in);
        System.out.println("참여할 사람은 몇 명인가요?");
        peopleNum = sc.nextInt();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        height = sc.nextInt();
    }

    public void setMap(){
        this.map = new int[this.height][this.peopleNum - 1];
        Random random = new Random();
        for(int i = 0; i < this.height; i++)
            for(int j = 0 ; j < this.peopleNum - 1; j++)
                this.map[i][j] = random.nextInt(2);
    }

    public void showMap(){
        for(int i = 0; i < this.height; i++) {
            for(int j = 0 ; j < this.peopleNum - 1; j++) {
                System.out.print("|");
                if(this.map[i][j] == 1) System.out.print("-");
                if(this.map[i][j] == 0) System.out.print(" ");
            }
            System.out.println("|");
        }
    }
}
