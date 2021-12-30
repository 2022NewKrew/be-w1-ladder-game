import domain.Ladder;
import domain.ParticipantList;
import view.InputView;
import view.OutputView;


public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ParticipantList participantList = new ParticipantList(inputView.getParticipants());
        int height = inputView.getHeight();

        Ladder ladder = new Ladder(participantList.getListSize(), height);

        OutputView outputView = new OutputView(ladder, participantList);
        outputView.showMap();
    }
}