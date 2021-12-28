public class LadderGame {

    public static void main(String[] args) {
        LadderInfo ladderInfo = LadderInfo.createByCli();
        Ladder ladder = new Ladder(ladderInfo);
        LadderRenderer.render(ladder);
    }
}
