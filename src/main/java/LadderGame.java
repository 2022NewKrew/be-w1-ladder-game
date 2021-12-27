public class LadderGame {

    public static void main(String[] args) {
        GameInputManager manager = new GameInputManager();
        GameStartInfo info = manager.getInputGameStartInfo();

        LadderGenerator generator = new LadderGenerator();
        Ladder ladder = generator.generate(info, new RandomConnector(System.currentTimeMillis()));

        LadderRenderer renderer = new LadderRenderer();
        renderer.render(ladder);
    }

}
