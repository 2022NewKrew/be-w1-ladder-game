import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ladder1 {
    static int[][] map;
    static int people_num;
    static int height;

    public static void get_input(){
        Scanner sc = new Scanner(System.in);
        System.out.println("참여할 사람은 몇 명인가요?");
        people_num = sc.nextInt();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        height = sc.nextInt();
    }

    public static void set_map(int people_num, int height){
        map = new int[height][people_num - 1];
        Random random = new Random();
        for(int i = 0; i < height; i++)
            for(int j = 0 ; j < people_num - 1; j++)
                map[i][j] = random.nextInt(2);
    }

    public static void show_map(){
        for(int i = 0; i < height; i++) {
            for(int j = 0 ; j < people_num; j++) {
                System.out.print("|");
                if(j == people_num - 1) continue;
                if(map[i][j] == 1) System.out.print("-");
                if(map[i][j] == 0) System.out.print(" ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        get_input();
        set_map(people_num, height);
        show_map();
    }
}
