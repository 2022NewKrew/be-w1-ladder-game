import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ladder {
    int person;
    int height;
    int width;
    char[][] ladder;

    Ladder(int person, int height) {
        self.person = person;
        self.height = height;
        self.width = 2 * person - 1;
    }
    
    void setPerson() throws IOException {
        person = Integer.parseInt(br.readLine());
    }

    void setHeight() throws IOException {
        height = Integer.parseInt(br.readLine());
    }

    void setWidth() {
        width = 2 * person - 1;
    }

    void initializeLadder() {
        ladder = new char[height][width];
    }

    void setLadder() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (j % 2 == 0) ladder[i][j] = '|';
                else {
                    ladder[i][j] = Math.random() < 0.5 ? ' ' : '-';
                }
            }
        }
    }

    void printLadder() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(ladder[i][j]);
            }
            System.out.println();
        }
    }
}

