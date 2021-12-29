import java.util.*;

public class RunGame {

    private static int participants;
    private static int height;

    private static void setParticipants() {
        Scanner sc = new Scanner(System.in);
        try {
            participants = sc.nextInt();
            checkParticipantsInput();
        } catch (InputMismatchException e) {
            System.out.println("참여할 사람은 몇 명인가요? (자연수를 입력해 주세요)");
            setParticipants();
        }
    }

    private static void setHeight() {
        Scanner sc = new Scanner(System.in);
        try {
            height = sc.nextInt();
            checkHeightInput();
        } catch (InputMismatchException e) {
            System.out.println("최대 사다리 높이는 몇 개인가요? (자연수를 입력해 주세요)");
            setHeight();
        }
    }

    private static void checkParticipantsInput() {
        if (participants < 1) {
            System.out.println("참여할 사람은 몇 명인가요? (최소 1명이 참가해야 합니다)");
            setParticipants();
        }
    }

    private static void checkHeightInput() {
        if (height < 1) {
            System.out.println("최대 사다리 높이는 몇 개인가요? (최소 높이는 1 입니다)");
            setHeight();
        }
    }

    public static void main(String[] args) {
        System.out.println("참여할 사람은 몇 명인가요?");
        setParticipants();

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        setHeight();

        Ladder ladder = new Ladder(participants, height);
        ladder.printLadder();
    }
}
