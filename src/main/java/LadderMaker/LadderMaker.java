package LadderMaker;

public class LadderMaker {
    private final RandomManager randomManager;
    public LadderMaker(){
        randomManager = new RandomManager();
    }

    public void makeLadder(Ladder ladder){
        for(int row = 0; row < ladder.getHeightOfLadder(); row++) {
            makeRow(ladder);
        }
    }

    public void makeRow(Ladder ladder){
        Line line = new Line();
        line.addElement(randomManager.getRandomBoolean());

        for(int column = 1; column < ladder.getNumOfPeople() - 1; column++){
            line.addElement(!line.getElement(column - 1) && randomManager.getRandomBoolean());
        }
        ladder.addConnectedInfo(line);
    }
}
