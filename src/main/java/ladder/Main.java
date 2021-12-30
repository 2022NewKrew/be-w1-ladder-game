package ladder;

import ladder.domain.Ladder;
import ladder.view.LadderView;


public class Main {


    public static void main(String[] args) throws Exception {
        //set ladder
        Ladder ladderObject = new Ladder();
        ladderObject.setValue(ladderObject.inputName(), ladderObject.inputHeight());
        ladderObject.initLine();
        ladderObject.shuffle();

        //set view of ladder
        LadderView ladderView = new LadderView(ladderObject);
        ladderView.display();
    }
}
