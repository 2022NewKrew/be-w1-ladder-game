package ladder;

import ladder.domain.Ladder;
import ladder.view.LadderView;


public class Main {


    public static void main(String[] args) throws Exception {
        //set ladder
        Ladder ladderObject = new Ladder(LadderView.inputName(), LadderView.inputHeight());
        ladderObject.initLine();
        ladderObject.shuffle();

        //set view of ladder
        ladderObject.ladderView.display(); //ladder객체에서 연결된 view객체로 이동 후 출력.
    }
}
