public class LadderGame {
    public static void main(String[] args){

        LadderInput li = new LadderInput();
        Ladder ladder = new Ladder(li);
        ladder.printLadder();
    }
}

