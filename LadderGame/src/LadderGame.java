import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    private BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private int userCnt, ladderHeight;
    private List<List<Boolean>> ladder;

    // 입력함수
    private void inputWidth () throws Exception {
        System.out.println("참여할 사람은 몇 명인가요?");
        this.userCnt = Integer.parseInt(bf.readLine());
    }
    private void inputHeight() throws Exception {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        this.ladderHeight = Integer.parseInt(bf.readLine());
    }

    // 사다리 생성
    public void makeLadder() throws Exception {
        this.inputWidth();
        this.inputHeight();

        this.ladder = new ArrayList<>(); // 새 사다리
        for(int h = 0; h<this.ladderHeight; h++) { // 한 줄씩 사다리를 생성
            ladder.add(makeRow());
        }
    }
    private List<Boolean> makeRow() { // 한 줄의 사다리 생성
        List<Boolean> row = new ArrayList<>();
        for(int w = 1; w<this.userCnt; w++) row.add((int)(Math.random() * 2) != 0); // 연결점 생성
        return row;
    }

    // 사다리 출력
    public void printLadder() throws Exception {
        this.makeLadder();

        StringBuilder sb = new StringBuilder();
        for(List<Boolean> row: this.ladder){ // 높이
            printRow(sb, row); // 한 줄을 출력
        }
        bw.write(sb.toString());
        bw.flush();
    }
    private void printRow(StringBuilder sb, List<Boolean> row) { // 한 줄 출력
        sb.append('|'); // 첫 막대기
        for(Boolean bridge: row){ // 너비
            // 중간다리 판단
            sb.append(bridge ? '-' : ' ');
            sb.append('|');
        }
        sb.append('\n'); // 줄바꿈
    }

    // 메인
    public static void main(String[] args) throws Exception {
        LadderGame lg = new LadderGame();
        lg.printLadder();
    }
}
