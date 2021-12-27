import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class LadderGame {
    private BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private int width, height;

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
        StringBuilder sb = new StringBuilder();
        for(int h=0; h<height; h++){ // 높이
            sb.append('|'); // 첫 막대기
            for(int w=1; w<width; w++){ // 너비
                // 중간다리를 난수로 생성
                sb.append((int) (Math.random() * 2) != 0 ? ' ' : '-');
                sb.append('|');
            }
            sb.append('\n'); // 줄바꿈
        }
        bw.write(sb.toString());
        bw.flush();
    }

    public static void main(String[] args) throws Exception {
        LadderGame lg = new LadderGame();

        lg.inputWidth();
        lg.inputHeight();

        lg.makeLadder();
    }
}
