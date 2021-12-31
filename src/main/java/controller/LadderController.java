package controller;

import domain.CalculateResult;
import repository.Ladder;
import domain.LadderInfoScanner;
import domain.LadderMaker;
import repository.NameToPointMapping;
import repository.PointToResultMapping;
import repository.ResultMapper;
import view.LadderRenderer;
import view.UserInteractController;
import java.util.stream.Stream;

public class LadderController {
    public LadderController(){ }
    public void ladderFlow(){
        UserInteractController userInteractController = new UserInteractController();
        Ladder ladder = makeLadder();
        ResultMapper resultMapper = makeResultMapper(ladder.getNameStream(), ladder.getResultStream());
        iterateCalculateResult(resultMapper, ladder);
        renderLadder(ladder);
        userInteractController.checkResult(resultMapper);
    }

    private Ladder makeLadder(){
        Ladder ladder = new LadderInfoScanner().getLadder();
        LadderMaker ladderMaker = new LadderMaker();
        ladder.addConnectedInfo(ladderMaker.makeConnectedInfo(
                        ladder.getHeightOfLadder(), ladder.getNumOfPeople()
                ));
        return ladder;
    }

    private void renderLadder(Ladder ladder){
        LadderRenderer ladderRenderer = new LadderRenderer();
        ladderRenderer.renderLadder(ladder);
    }

    private ResultMapper makeResultMapper(Stream<String> names, Stream<String> results){
        NameToPointMapping nameToPoint = new NameToPointMapping();
        PointToResultMapping pointToResult = new PointToResultMapping();

        names.forEach(nameToPoint::addName);
        results.forEach(pointToResult::addResult);

        return new ResultMapper(nameToPoint, pointToResult);
    }

    private void iterateCalculateResult(ResultMapper resultMapper, Ladder ladder){
        CalculateResult calculateResult = new CalculateResult();
        for(int row = ladder.getHeightOfLadder() - 1; row >= 0; row--){
            calculateResult.calculateResult(resultMapper, ladder.getConnectedStream(row));
        }
    }
}
