package ladder;

public class Ladder {

    // TODO - 1. 들여쓰기를 1단계로 줄일 것

    private final int participants;
    private final int height;
    private final boolean[][] bridges;

    public Ladder(int participants, int height) {
        this.participants = participants;
        this.height = height;
        this.bridges = new boolean[height][participants - 1];
        connectBridges();
    }

    private void connectBridges() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < participants - 1; x++) {
                connectBridge(x, y);
            }
        }
    }

    private void connectBridge(int x, int y) {
        if (isValidConnection(x, y)) {
            bridges[y][x] = true;
        }
    }

    private boolean isValidConnection(int x, int y) {
        if (x == 0) {
            return getRandomBoolean();
        }
        return !isAlreadyConnected(x, y) && getRandomBoolean();
    }

    private boolean isAlreadyConnected(int x, int y) {
        return bridges[y][x - 1];
    }

    private boolean getRandomBoolean() {
        return Math.random() > 0.5;
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < participants - 1; x++) {
                sb.append("|");
                sb.append((bridges[y][x]) ? "-" : " ");
            }
            sb.append("|\n");
        }
        System.out.print(sb);
    }

}
