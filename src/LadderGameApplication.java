
public class LadderGameApplication {

    public static void main(String[] args) {
        LadderGameService ladderGameService = new LadderGameService();

        ladderGameService.makeLadder();
        ladderGameService.printLadderInfo();
    }
}
