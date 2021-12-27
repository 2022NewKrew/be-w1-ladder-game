public class LadderGame {
    private final InputParameter iPara = new InputParameter();
    private final LadderData ladderData = new LadderData();

    public LadderGame() {
        System.out.println("사다리 게임");
    }

    public void requestParameter() {
        iPara.requestMember();
        iPara.requestLadderHeight();
    }

    public void createLadder() {
        ladderData.build(iPara);
    }

    public void printLadder() {
        ladderData.print();
    }

    public void closeGame() {
        iPara.closeScanner();
    }
}
