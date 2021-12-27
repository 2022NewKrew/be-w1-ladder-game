import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Ladder {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int person;
    int height;
    int width;
    char[][] ladder;


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

public class Laddergame {
    public static void main(String[] args) throws IOException {
        Ladder ladder = new Ladder();
        System.out.println("참여할 사람은 몇 명인가요?");
        ladder.setPerson();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        ladder.setHeight();
        ladder.setWidth();
        ladder.initializeLadder();
        ladder.setLadder();
        ladder.printLadder();
    }
}