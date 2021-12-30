import controller.GameManager;
import domain.Ladder;
import domain.Participant;
import domain.ParticipantList;
import domain.ResultList;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ParticipantList participantList = new ParticipantList(inputView.getParticipants());
        ResultList resultList = new ResultList(inputView.getResultList());
        int height = inputView.getHeight();

        Ladder ladder = new Ladder(participantList.getListSize(), height);

        OutputView outputView = new OutputView(ladder, participantList,resultList);
        outputView.showMap();

        GameManager gameManager = new GameManager(inputView, outputView, participantList);
        gameManager.play();
    }
}