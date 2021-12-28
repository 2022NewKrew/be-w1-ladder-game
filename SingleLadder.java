public class SingleLadder extends Ladder {
    private final int M;

    public SingleLadder(int M) {
        this.M = M;
    }

    public void printLadder() {
        for(int i = 0; i < M; i ++) {
            System.out.println('|');
        }
    }
}
