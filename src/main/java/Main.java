public class Main {

    public static void main(String[] args) {
        CUI cui = new CUI();
        Ladder ladder = new Ladder(cui.input());
        cui.printNames();
        ladder.printLadder();
    }

}
