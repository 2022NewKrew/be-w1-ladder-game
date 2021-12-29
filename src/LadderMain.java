public class LadderMain {
    public static void main(String[] args) {
        startGame();
    }

    public static void startGame(){
        Ladder ladder = new Ladder(LadderUI.getNumOfPeople(),LadderUI.getHeight());
        LadderUI.printLadder(ladder);
    }
}
