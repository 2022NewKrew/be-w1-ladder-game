package inout;

import ladder.Bridge;
import ladder.LadderInfo;

import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

//입출력 담당 클래스
public class InputOutputInfo {
    private Scanner scanner;

    private InputOutputInfo() {
        scanner = new Scanner(System.in);
    }

    public static class LazyHolder {
        public static final InputOutputInfo INSTANCE = new InputOutputInfo();
    }

    public static InputOutputInfo getInstance() {
        return LazyHolder.INSTANCE;
    }

    //참여할 플레이어 수 입력
    public int inputPlayersCnt() {
        System.out.println("참여할 사람은 몇 명인가요?");

        return scanner.nextInt();
    }

    //사다리 높이 입력
    public int inputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");

        return scanner.nextInt();
    }

    //사다리 정보 출력
    public void printLadder(LadderInfo ladderInfo) {
        List<List<Bridge>> ladder = ladderInfo.getLadder();

        for (List<Bridge> row : ladder) {
            IntStream.range(0, ladderInfo.getWidth())
                    .forEach(i -> System.out.print(row.get(i).getValue()));
            System.out.println();
        }
    }
}
