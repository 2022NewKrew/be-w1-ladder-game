import ladder.service.LadderGameService;
import ladder.service.LadderGameServiceImpl;

public class Main {

    public static void main(String[] args) {
        LadderGameService ladderGameService = new LadderGameServiceImpl();
        ladderGameService.run();
    }
}
