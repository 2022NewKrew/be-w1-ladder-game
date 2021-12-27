import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

//사다리 게임을 위한 사다리 생성 클래스
public class LadderGenerator {

    private final char[] CHARSET = {' ', '-'};
    private char[][] generatedLadder;

    //사다리를 생성하여 generatedLadder에 저장
    public void generateLadder(int players, int height) {
        if (!isValidate(players, height)) return;

        int line = players - 1;
        generatedLadder = new char[height][line];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < line; j++) {
                generatedLadder[i][j] = randomChar();
            }
        }
    }

    //generatedLadder에 저장된 사다리를 포맷에 맞게 출력
    public void printLadder(BufferedWriter bw) throws IOException {
        if (generatedLadder == null) return;

        for (int i = 0; i < generatedLadder.length; i++) {
            bw.write("\n|");
            for (int j = 0; j < generatedLadder[0].length; j++) {
                bw.write(generatedLadder[i][j] + "|");
            }
        }
        bw.close();
    }

    //random char 생성
    private char randomChar() {
        Random rand = new Random();
        int randInt = rand.nextInt(2);

        return CHARSET[randInt];
    }

    //플레이어 수와 사다리 높이 정합성 검사
    private boolean isValidate(int players, int height) {
        return !(players <= 1 || height <= 0);
    }
}
