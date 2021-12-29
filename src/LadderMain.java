public class LadderMain {
    public static void main(String[] args) {
        startGame();
    }

    public static void startGame(){
        int numOfPeople = LadderUI.getNumOfPeople();
        int height = LadderUI.getHeight();

        Ladder ladder = new Ladder(numOfPeople, height);

        LadderUI.printLadder(ladder);
    }
}
