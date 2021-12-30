import ladder.LadderGameService;
import ladder.LadderGameServiceImpl;

public class Main {

    public static void main(String[] args) {
        LadderGameService ladderGameService = new LadderGameServiceImpl();
        ladderGameService.run();
    }
}
