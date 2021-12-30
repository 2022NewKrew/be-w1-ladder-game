package ladder;

import ladder.domain.Ladder;
import ladder.view.LadderView;

public class Main {


    public static void main(String[] args)
    {
        //set ladder
        Ladder ladderObject = new Ladder();
        ladderObject.initLine();
        ladderObject.shuffle();

        //set view of ladder
        LadderView ladderView = new LadderView(ladderObject);
        ladderView.display();
    }
}
