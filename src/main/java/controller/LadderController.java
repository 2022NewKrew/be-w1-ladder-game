package controller;

import domain.CalculateResult;
import repository.Ladder;
import domain.LadderInfoScanner;
import domain.LadderMaker;
import view.LadderRenderer;

public class LadderController {
    public LadderController(){ }
    public void ladderFlow(){
        Ladder ladder = makeLadder();
        CalculateResult calculateResult = new CalculateResult(ladder);
        calculateResult.calculateResult();;
        renderLadder(ladder);
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
