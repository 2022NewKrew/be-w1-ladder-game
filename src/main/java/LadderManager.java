import domain.Ladder;
import domain.Person;
import view.LadderView;

import java.util.Scanner;

public class LadderManager {
    public void startLadder(){
        Scanner sc = new Scanner(System.in);
        int height;

        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        Person person = new Person(sc.nextLine().split(","));
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        height = sc.nextInt();

        Ladder ladder = new Ladder(person.getPerson().size(), height);
        LadderView ladderView = new LadderView(ladder, person);

        ladderView.view();
    }
}
