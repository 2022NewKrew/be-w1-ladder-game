import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    private BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private int width, height;
    private List<List<Boolean>> ladder;

    // 입력함수
    public void inputWidth () throws Exception {
        System.out.println("참여할 사람은 몇 명인가요?");
        this.width = Integer.parseInt(bf.readLine());
    }
    public void inputHeight() throws Exception {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        this.height = Integer.parseInt(bf.readLine());
    }

    // 사다리 생성
    public void makeLadder() throws Exception {
        this.inputWidth();
        this.inputHeight();

        this.ladder = new ArrayList<>(); // 새 사다리
        for(int h=0; h<this.height; h++) {
            List<Boolean> row = new ArrayList<>(); // 한 줄
            for(int w=1; w<this.width; w++) row.add((int)(Math.random() * 2) != 0); // 연결점 생성
            ladder.add(row);
        }
    }

    // 사다리 출력
    public void printLadder() throws Exception {
        this.makeLadder();

        StringBuilder sb = new StringBuilder();
        for(List<Boolean> row: this.ladder){ // 높이
            sb.append('|'); // 첫 막대기
            for(Boolean bridge: row){ // 너비
                // 중간다리 판단
                sb.append(bridge ? '-' : ' ');
                sb.append('|');
            }
            sb.append('\n'); // 줄바꿈
        }
        bw.write(sb.toString());
        bw.flush();
    }

    public static void main(String[] args) throws Exception {
        LadderGame lg = new LadderGame();
        lg.printLadder();
    }
}
