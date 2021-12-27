import java.io.*;

public class Main {
    static public void main(String[] args) throws IOException {
        startGame();
    }

    static private void startGame() throws IOException {
        //init
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        LadderGenerator ladderGenerator = new LadderGenerator();

        //input values
        int players = inputInt(bf, bw, "참여할 사람은 몇 명인가요?\n");
        int height = inputInt(bf, bw, "최대 사다리 높이는 몇 개인가요?\n");

        //generate & print ladder
        ladderGenerator.generateLadder(players, height);
        ladderGenerator.printLadder(bw);
    }

    static private int inputInt(BufferedReader bf, BufferedWriter bw, String msg) throws IOException {
        bw.write(msg);
        bw.flush();
        return Integer.parseInt(bf.readLine());
    }

}
