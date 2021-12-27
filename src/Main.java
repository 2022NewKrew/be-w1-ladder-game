import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //System.out.print("h");
        Scanner scanner = new Scanner(System.in);

        System.out.println("참여할 사람은 몇 명인가요?");
        int n_people = scanner.nextInt();

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int max_height = scanner.nextInt();

        System.out.printf("참여인원: %d, 최대 사다리 높이: %d\n",n_people, max_height);

        Ladder test1 = new Ladder(n_people, max_height);
        test1.print_ladder();
    }
}
