import java.util.Scanner;

public class LadderGame {
    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("참여할 사람은 몇 명인가요?");
        int people = inputNumber();

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int heightLadder = inputNumber();

        Ladder ladder = new Ladder(people, heightLadder);
        System.out.println(ladder);
    }

    static int inputNumber() {
        try {
            return getPositiveInteger();
        } catch (NumberFormatException e) {
            System.out.println("양의 정수를 입력해주세요.");
            return inputNumber();
        }
    }

    private static Integer getPositiveInteger() {
        Integer value = Integer.valueOf(in.nextLine());
        if (value <= 0) {
            throw new NumberFormatException();
        }
        return value;
    }
}
