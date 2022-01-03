import domain.*;
import view.LadderView;

import java.util.Scanner;

public class LadderManager {
    private final Scanner sc = new Scanner(System.in);
    private LadderView ladderView;

    public void startLadder(){
        inputLadderInfo();
        inputLadderResult();
    }

    public void inputLadderInfo(){
        Person person = inputPerson();
        Results result = inputResult();
        Ladder ladder = inputLadder(person);

        LadderResult ladderResult = new LadderResult(ladder, person, result);
        ladderView = new LadderView(ladderResult);
        ladderView.printLadder();
    }

    public void inputLadderResult(){
        String inputResult;

        while(!(inputResult = inputName()).equals(LadderConst.GAME_END)){
            ladderView.printResult(inputResult);
        }

        System.out.println("게임을 종료합니다.");
    }

    private String inputName(){
        System.out.println("결과를 보고싶은 사람은?");
        return sc.nextLine();
    }

    private Person inputPerson(){
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return new Person(sc.nextLine().split(","));
    }

    private Results inputResult(){
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return new Results(sc.nextLine().split(","));
    }

    private Ladder inputLadder(Person person){
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = Integer.parseInt(sc.nextLine());

        return new Ladder(person.getPerson().size(), height);
    }
}
