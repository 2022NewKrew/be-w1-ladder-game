import main.java.domain.Ladder;
import main.java.view.InputView;
import main.java.view.OutputView;

import java.util.*;

public class Main {
    // 자주 쓸 것 같은 애들은 밖에다 빼놓기
    static List<String> peopleNameList;
    static int ladderHeight;
    static List<String> resultList;

    public static void main(String[] args) {

        // input 입력
        peopleNameList = InputView.inputNameList();
        resultList = InputView.inputResultList();
        ladderHeight = InputView.inputLadderHeight();

        // ladder 생성
        Ladder ladder = new Ladder(peopleNameList,resultList, ladderHeight);

        // ladder 출력
        OutputView.printLadder(ladder);

        // 결과 출력후 필요한 입력 받아 결과 출력
        while(true){
            System.out.println("결과를 보고 싶은 사람은?");
            String name = InputView.inputPersonName();
            if(name.equals("춘식이")){
                break;
            }

            System.out.println("실행 결과");
            OutputView.printResult(ladder, name);
        }
    }
}
