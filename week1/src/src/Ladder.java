import java.util.Random;
import java.util.Scanner;

public class Ladder {
    static int[][] map;
    static int peopleNum;
    static int height;

    public static void getInput(){
        Scanner sc = new Scanner(System.in);
        System.out.println("참여할 사람은 몇 명인가요?");
        peopleNum = sc.nextInt();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        height = sc.nextInt();
    }

    public static void setMap(){
        map = new int[height][peopleNum - 1];
        Random random = new Random();
        for(int i = 0; i < height; i++)
            for(int j = 0 ; j < peopleNum - 1; j++)
                map[i][j] = random.nextInt(2);
    }

    public static void showMap(){
        for(int i = 0; i < height; i++) {
            for(int j = 0 ; j < peopleNum - 1; j++) {
                System.out.print("|");
                if(map[i][j] == 1) System.out.print("-");
                if(map[i][j] == 0) System.out.print(" ");
            }
            System.out.println("|");
        }
    }

    public static void main(String[] args) {
        getInput();
        setMap();
        showMap();
    }
}
