public class LadderGame {
    private final LadderInfoScanner input = new LadderInfoScanner();
    private final LadderPrinter printer = new LadderPrinter();

    void startLadderGame(){
        LadderInfo info = input.getLadderInfo();
        Ladder ladder = new Ladder(info);
        printer.printLadder(ladder);
    }
}
