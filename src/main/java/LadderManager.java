import domain.Ladder;
import view.LadderView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LadderManager {
    private List<String> userNames;
    private int height;

    public LadderManager() {
    }

    public void startLadder(){
        inputUI();

        Ladder ladder = new Ladder(userNames.size(), height);
        LadderView ladderView = new LadderView(ladder);

        ladderView.view(userNames);
    }

    private void inputUI(){
        Scanner sc = new Scanner(System.in);

        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        parseUser(sc.nextLine());
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        height = sc.nextInt();
    }

    private void parseUser(String userName){
        userNames = new ArrayList<>(List.of(userName.split(",")));
    }


}
