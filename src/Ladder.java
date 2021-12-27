import java.util.ArrayList;

public class Ladder {

    private ArrayList<String> ladder;
    private int people;
    private int height;
    private StringBuilder sb;

    public Ladder() {
        ladder = new ArrayList<String>();
        people = 2;
        height = 5;
        sb = new StringBuilder();
        makeLadder();
    }

    public Ladder(int p, int h) {
        ladder = new ArrayList<String>();
        people = p;
        height = h;
        sb = new StringBuilder();
        makeLadder();
    }

    public char getRandomBridge() {
        double randNum;
        randNum = Math.random();
        if(randNum >= 0.5)
            return ' ';
        return '-';
    }

    private String makeLayer() {
        sb.setLength(0);
        for(int i=1;i<people;i++) {
            sb.append('|');
            sb.append(getRandomBridge());
        }
        sb.append('|');
        return sb.toString();
    }

    public void makeLadder() {
        for(int i=0;i<height;i++) {
            ladder.add(makeLayer());
        }
    }

    public void printLadder() {
        for(String s : ladder) {
            System.out.println(s);
        }
    }

}
