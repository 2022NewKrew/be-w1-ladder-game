public class LadderGenerator {

    public Ladder generate(GameStartInfo info, RandomConnector connector) {
        Ladder ladder = new Ladder(info);
        for(int i = 0; i < 5; i++) {
            connector.connect(ladder);
        }
        return ladder;
    }
}
