import java.util.Scanner;

public class LadderGame {
    public static void main(String[] args) {
        int people;
        int height;

        Scanner sc = new Scanner(System.in);
        System.out.println("참여할 사람은 몇 명인가요?");
        people = sc.nextInt();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        height = sc.nextInt();

        char[][] ladder = new char[height][2*people-1];
        for (int r=0; r<height; r++) {
            for (int c=0; c<2*people-1; c++) {
                if (c % 2 == 0) {
                    ladder[r][c] = '|';
                }
                else if (Math.random() < 0.5) {
                    ladder[r][c] = '-';
                }
                else {
                    ladder[r][c] = ' ';
                }
            }
        }



//        System.out.println(people);
//        System.out.println(height);


    }
}