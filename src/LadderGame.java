public class LadderGame {

    public static void startLadderGame(){
        LadderInfo info = LadderInfoScanner.getLadderInfo();
        Ladder ladder = new Ladder(info);
        LadderPrinter.printLadder(ladder);
    }
}
