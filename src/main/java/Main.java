public class Main {

    public static void main(String[] args) {
        Player player = new Player();
        Ladder ladder = new Ladder(player.input());
        player.printNames();
        ladder.printLadder();
    }

}
