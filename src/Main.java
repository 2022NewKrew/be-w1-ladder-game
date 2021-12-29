import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //TODO:입력부 변경
        Scanner scan = new Scanner(System.in);

        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요");
        String[] participants = scan.nextLine().split(",");

        System.out.println("최대 사다리 높이는 몇 개 인가요?");
        int ladderHeight = scan.nextInt();

        LadderGame game = new LadderGame(new ArrayList<>(Arrays.asList(participants)), ladderHeight);
        game.displayLadder();
    }
}
