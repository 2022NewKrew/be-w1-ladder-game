import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        int NumberOfPeople;
        int HeightOfLadder;

        // 입력 받기
        Scanner sc = new Scanner(System.in);
        System.out.println("참여할 사람은 몇 명인가요?");
        NumberOfPeople = sc.nextInt();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        HeightOfLadder = sc.nextInt();
        Ladder ladder = new Ladder(NumberOfPeople, HeightOfLadder);

        // 출력 하기
        ladder.draw();
    }
}
