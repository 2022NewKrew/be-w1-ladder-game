package domain.sadari;

import service.SadariFinder;
import service.SadariMaker;
import service.SadariPrinter;

public class Sadari {

    private final SadariMaker sadariMaker;
    private final SadariPrinter sadariPrinter;
    private final SadariFinder sadariFinder;

    public Sadari(SadariMaker sadariMaker, SadariPrinter sadariPrinter, SadariFinder sadariFinder) {
        this.sadariMaker = sadariMaker;
        this.sadariPrinter = sadariPrinter;
        this.sadariFinder = sadariFinder;
    }

    public void startGame() {
        sadariMaker.makeSadariGame();
        sadariPrinter.printSadariGame();
    }

    public void play(String userName) {
        sadariPrinter.printPlayResult(sadariFinder.find(userName));
    }

    public void playAll() {
        sadariPrinter.printAllPlayResult(sadariFinder.findAll());
    }

}