public class LadderGame {
    public static void main(String[] args) {
        System.out.println("사다리 게임을 시작합니다.");

        LadderInputManager ladderInputManager = new LadderInputManager();
        LadderMaker ladderMaker = new LadderMaker(ladderInputManager);
        LadderRenderer.render(ladderInputManager, ladderMaker);
    }
}