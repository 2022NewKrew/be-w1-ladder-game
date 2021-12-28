import java.util.Random;


public class LadderGame {
    private static char[][] ladder;


    public static void makeLadder(int numOfPlayers, int height) {
        Random random = new Random();
        int width = numOfPlayers * 2 - 1;
        ladder = new char[height][width];

        for (int i = 0; i < height; i++){
            for (int j = 0; j < width; j++){
                ladder[i][j] = (j % 2 == 0) ? '|' : (random.nextBoolean() ? ' ' : '-');
            }
        }
    }

    public static void drawLadder(int numOfPlayers, int height) {
        StringBuilder sb = new StringBuilder();
        int width = numOfPlayers * 2 - 1;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                sb.append(ladder[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
