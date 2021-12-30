import java.util.List;

public class PrintLadder {
    public static void print(Ladder ladder) {
        List<Line> ladderInfo = ladder.getLadderInfo();
        for (Line line : ladderInfo) {
            System.out.println(line.line);  // 이부분 Line class랑 결합을 해제하는 형식으로 짜볼것
        }
    }
}