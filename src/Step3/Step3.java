package Step3;

import java.util.Scanner;

public class Step3 {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("참여할 사람 이름을 입력하세요");
        String people = sc.nextLine();

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = sc.nextInt();

        Ladder ladder = Ladder.createLadder(people, height);
        ladder.printLadder();
    }
}
