public class LadderGame {
    public static void main(String[] args) {
        LadderInfo info = new LadderInfo();

        Ladder ladder = new Ladder(info);

        LadderRenderer renderer = new LadderRenderer();
        renderer.render(ladder);
    }
}
