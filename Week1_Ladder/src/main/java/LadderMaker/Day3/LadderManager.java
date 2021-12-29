package LadderMaker.Day3;

public class LadderManager {
    public LadderManager(){ }
    public void ladderFlow(){
        Ladder ladder = makeLadder();
        renderLadder(ladder);
    }

    private Ladder makeLadder(){
        Ladder ladder = new LadderInfoScanner().getLadder();
        LadderMaker ladderMaker = new LadderMaker();
        ladderMaker.makeLadder(ladder);
        return ladder;
    }

    private void renderLadder(Ladder ladder){
        LadderRenderer ladderRenderer = new LadderRenderer();
        ladderRenderer.renderLadder(ladder);
    }
}
