import domain.LadderGame;
import domain.Participant;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int participantNumber;
        int height;
        Scanner sc = new Scanner(System.in);

        System.out.println("참여할 사람은 몇 명인가요? (1 명 이상 입력해주세요)");
        participantNumber = sc.nextInt();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        height = sc.nextInt();

        Participant participant = new Participant(participantNumber);
        LadderGame game = new LadderGame(participant, height);

        game.play();

        sc.close();
    }
}
