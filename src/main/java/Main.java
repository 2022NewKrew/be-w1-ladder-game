public class Main {
    public static void main(String[] args) {
        // 게임인원, 사다리높이 받음
        StartInfo startInfo = InputManager.makeStartInfo();

        // 사다리 랜덤 생성
        Ladder ladder = new Ladder(startInfo.getNumPeople(), startInfo.getMaxHeight());

        // 사다리 프린트
        PrintManager.printLadder(ladder.getLadder());
        }
    }

