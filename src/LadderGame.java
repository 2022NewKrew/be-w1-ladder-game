public class LadderGame {

    private LadderGame() {
        //instance 생성 제한용 생성자
    }

    public static void startLadderGame() {
        LadderInfo info = LadderInfoScanner.getLadderInfo();
        Ladder ladder = new Ladder(info);
        LadderPrinter.printLadder(ladder);
    }
}
