public class LadderGame {
    public static void main(String[] args) {
        LadderGameStarter starter = new LadderGameStarter();
        int numOfPeople = starter.getNumOfPeople();
        int heightOfLadder = starter.getHeightOfLadder();

        Ladder ladder = new Ladder(numOfPeople, heightOfLadder);

        LadderRenderer.render(ladder.getNumOfPeople(), ladder.getHeightOfLadder(), ladder.getConnections());
    }
}
