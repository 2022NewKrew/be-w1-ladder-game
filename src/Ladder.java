public class Ladder {
    private int numberOfPeople;
    private int ladderHeight;
    private char[][] ladder;

    Ladder(int numberOfPeople, int ladderHeight) {
        this.numberOfPeople = numberOfPeople;
        this.ladderHeight = ladderHeight;

        ladder = new char[ladderHeight][numberOfPeople * 2 - 1];
        makeLine();
    }

    private void makeLine() {
        for(int i = 0; i < ladderHeight; i++) {
            for(int j = 0; j < ladder[i].length; j++) {
                if(j % 2 == 1) { //랜덤 '-'
                    ladder[i][j] = ((int)(Math.random()*2) == 1) ? '-' : ' ';
                } else {
                    ladder[i][j] = '|';
                }
            }
        }
    }

    @Override
    public String toString() {
        String ret = "";
        for (char[] chars : ladder) {
            ret += String.valueOf(chars) + "\n";
        }
        return ret;
    }
}
