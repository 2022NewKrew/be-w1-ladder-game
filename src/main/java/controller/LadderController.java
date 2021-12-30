package controller;

import domain.CalculateResult;
import repository.Ladder;
import domain.LadderInfoScanner;
import domain.LadderMaker;
import view.LadderRenderer;
import view.UserInteractController;

public class LadderController {
    public LadderController(){ }
    public void ladderFlow(){
        Ladder ladder = makeLadder();
        CalculateResult calculateResult = new CalculateResult(ladder);
        calculateResult.calculateResult();;
        renderLadder(ladder);
        UserInteractController userInteractController = new UserInteractController();
        userInteractController.checkResult(ladder.getResultMapping());
    }

    private Ladder makeLadder(){
        Ladder ladder = new LadderInfoScanner().getLadder();
        LadderMaker ladderMaker = new LadderMaker();
        ladderMaker.makeLadder(ladder);
        return ladder;
    }

    private void renderLadder(Ladder ladder){
        LadderRenderer ladderRenderer = new LadderRenderer();
        ladderRenderer.renderLadder(ladder);
    }
}
