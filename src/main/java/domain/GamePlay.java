package domain;

public class GamePlay {

    private NameRepository nameRepository;
    private Ladder ladder;

    public GamePlay(NameRepository nameRepository, Ladder ladder) {
        this.nameRepository = nameRepository;
        this.ladder = ladder;
        ladderDown();
    }

    private void ladderDown(){
        for(Line line: ladder.getLadder()){
            participantsSwap(line);
        }
    }

    private void participantsSwap(Line line){
        for(int i=0; i<line.getLine().size(); i++){
            if (line.getLine().get(i)) {
                nameRepository.swap(i);
            }
        }
    }

}

