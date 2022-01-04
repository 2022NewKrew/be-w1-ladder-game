import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class LADDER {

    static private char[][] ladder_array;

    public static int get_number_people(){
        Scanner sc = new Scanner(System.in);
        System.out.println("참여할 사람은 몇 명인가요?");
        return sc.nextInt();
    }

    public static int get_ladder_height(){
        Scanner sc = new Scanner(System.in);
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return sc.nextInt();
    }

    public static char[][] ladder_array(int number_people, int ladder_height){
        int print_ladder_columns;
        int print_ladder_rows;

        print_ladder_columns = number_people + number_people -1;
        print_ladder_rows = ladder_height;
        return new char[print_ladder_rows][print_ladder_columns];
    }

    public static void assign_ladder_array(){

        Random random = new Random();
        random.setSeed(System.currentTimeMillis());

        for (int row=0; row < ladder_array.length;row++){
            for (int col=0; col<ladder_array[row].length;col++){
                if (col%2 == 1){
                    ladder_array[row][col] = random_bridge(random);
                }
                else{
                    ladder_array[row][col] = '|';
                }
            }
        }
    }

    public static char random_bridge(Random random){
        return (random.nextBoolean()) ? '-' : ' ';
    }

    public static void print_ladder(char[][] ladder){
        for (int row=0; row < ladder.length;row++){
            for (int col=0;col<ladder[row].length;col++){
                System.out.print(ladder[row][col]);
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args){
        int number_people;
        int max_ladder_height;

        number_people = get_number_people();
        max_ladder_height = get_ladder_height();

        ladder_array = ladder_array(number_people, max_ladder_height);
        assign_ladder_array();
        print_ladder(ladder_array);
    }

}
