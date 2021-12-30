package ladder.view;

import ladder.domain.Ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class LadderGame {

    private Ladder ladder;

    //
    // 사용자로부터 입력을 받아 사다리를 생성합니다.
    //
    private void inputLadder() {
        Scanner sc = new Scanner(System.in);
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        StringTokenizer st = new StringTokenizer(sc.nextLine(), ",");
        List<String> personNames = new ArrayList<String>();
        while(st.hasMoreTokens()){
            personNames.add(st.nextToken());
        }

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = sc.nextInt();

        try {
            this.ladder = new Ladder(personNames, height);
        } catch (IllegalArgumentException e) {
            System.err.println(e);
        }
    }

    public void start() {
        inputLadder();
        if (ladder != null) {
            System.out.println(ladder);
        }
    }
}
