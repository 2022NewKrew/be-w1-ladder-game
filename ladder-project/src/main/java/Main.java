import domain.LadderGame;
import domain.Participant;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int participantNumber = inputFromScreen("참여할 사람은 몇 명인가요? (1 명 이상 입력해주세요)", sc);
            int height = inputFromScreen("최대 사다리 높이는 몇 개인가요?", sc);

            Participant participant = new Participant(participantNumber);
            LadderGame game = new LadderGame(participant, height);

            game.play();
        }
    }

    //이 메서드가 (입력/출력) 2가지 일을 한다고 봐야할지 하나의 일을 한다고 봐야할지 잘 모르겠습니다..
    public static int inputFromScreen(String message, Scanner scanner) {
        System.out.println(message);
        return scanner.nextInt();
    }
}
