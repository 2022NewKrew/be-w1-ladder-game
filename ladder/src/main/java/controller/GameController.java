package controller;

import domain.Ladder;
import domain.Participant;
import domain.Result;
import view.GameInputOutputManager;

import java.util.List;
import java.util.stream.Collectors;

public class GameController {
    private final GameInputOutputManager gameInputOutputManager;

    public GameController(GameInputOutputManager gameInputOutputManager){
        this.gameInputOutputManager = gameInputOutputManager;
    }

    public void startGame(){
        List<Participant> participants = gameInputOutputManager.getParticipantsInfo()
                .stream()
                .map(Participant::new)
                .collect(Collectors.toList());
        List<Result> results = gameInputOutputManager.getResultsInfo()
                .stream()
                .map(Result::new)
                .collect(Collectors.toList());
        int ladderHeight = gameInputOutputManager.getLadderInfo();

        Ladder ladder = new Ladder(participants, results, ladderHeight);
        gameInputOutputManager.printLadder(ladder);

        selectLine(ladder);
    }

    private void selectLine(Ladder ladder){
        String name = "";
        do{
            name = gameInputOutputManager.getSelectedName();
            gameInputOutputManager.printGameResult(ladder, name);
        }while(!name.equals("춘식이"));
    }
}
