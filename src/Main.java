import java.util.*;

public class Main {
    public static int MAX_NAME_LENGTH = 5;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> participants = inputParticipants(scan);
        int ladderHeight = inputLadderHeight(scan);

        LadderGame game = new LadderGame(new ArrayList<>(participants), new Ladder(participants.size(), ladderHeight), new StandardOutDisplayLadder());
        game.displayLadder();
    }

    public static List<String> inputParticipants(Scanner scan) {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요");
        List<String> participants = new ArrayList<>(Arrays.asList(scan.nextLine().split(",")));

        if (participants.isEmpty() || participants.stream().anyMatch(s -> s.length() > MAX_NAME_LENGTH)) {
            System.out.println("잘못 입력하셨습니다!");
            System.out.println("이름은 " + MAX_NAME_LENGTH + "자 이하여야 합니다.\n");
            return inputParticipants(scan);
        }

        return participants;
    }

    public static int inputLadderHeight(Scanner scan) {
        System.out.println("최대 사다리 높이는 몇 개 인가요?");
        String height = scan.nextLine();

        if(height.chars().allMatch(Character::isDigit) && Integer.parseInt(height) > 0) {
            return Integer.parseInt(height);
        }

        System.out.println("잘못 입력하셨습니다!");
        System.out.println("양의 정수만 입력해주세요\n");
        return inputLadderHeight(scan);
    }
}
