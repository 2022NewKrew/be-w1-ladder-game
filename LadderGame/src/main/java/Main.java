import domain.Ladder;
import view.InputView;
import view.OutputView;


public class Main {
    public static void main(String[] args) {

        InputView inputView = new InputView();
        String[] participants = inputView.getParticipants();
        int height = inputView.getHeight();

        Ladder ladder = new Ladder(participants.length, height);

        OutputView outputView = new OutputView(ladder, participants);
        outputView.showMap();

    }
}
