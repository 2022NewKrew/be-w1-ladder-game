
public class Sadari {

    private final SadariMaker sadariMaker;
    private final SadariPrinter sadariPrinter;

    public Sadari(Users users, int numberOfPeople, int numberOfLadder) {
        SadariMap sadariMap = new SadariMap(numberOfPeople, numberOfLadder);
        this.sadariMaker = new SadariMaker(sadariMap);
        this.sadariPrinter = new SadariPrinter(users, sadariMap);
    }

    public void startGame() {
        sadariMaker.makeSadariGame();
        sadariPrinter.printSadariGame();
    }
}