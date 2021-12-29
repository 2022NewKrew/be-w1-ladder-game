package LadderMaker.Day3;

public class LadderMaker {
    private RandomManager randomManager;
    public LadderMaker(){
        randomManager = new RandomManager();
    }

    public void makeLadder(Ladder ladder){
        for(int row = 0; row < ladder.getHeightOfLadder(); row++) {
            makeRow(ladder, row);
        }
    }

    public void makeRow(Ladder ladder, int row){
        ladder.addConnectedInfo(row, randomManager.getRandomBoolean());

        for(int column = 1; column < ladder.getNumOfPeople() - 1; column++){
            ladder.addConnectedInfo(row,
                    (!ladder.getConnectedInfo(row, column - 1) && randomManager.getRandomBoolean())
            );
        }
    }
}
