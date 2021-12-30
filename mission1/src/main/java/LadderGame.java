public class LadderGame {
    private static final int NAME_LEN_MAX = 5;

    public static void main(String[] args) {
        System.out.println("사다리 게임을 시작합니다.");

        LadderInputManager ladderInputManager = new LadderInputManager(NAME_LEN_MAX);
        LadderMaker ladderMaker = new LadderMaker(ladderInputManager, NAME_LEN_MAX);
        LadderRenderer ladderRenderer = new LadderRenderer(NAME_LEN_MAX);

        ladderRenderer.render(ladderInputManager, ladderMaker);
    }
}