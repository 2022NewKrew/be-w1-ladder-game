public class Main {
    public static void main(String[] args) {
        // 게임 정보 입력받음
        StartInfo startInfo = InputManager.makeStartInfo();

        // 사다리 생성
        Ladder ladder = new Ladder(startInfo.getNamePeople(), startInfo.getNumPeople(), startInfo.getMaxHeight());

        // 참가자 프린트
        PrintManager.printPeople(ladder.getNamePeople());
        // 사다리 프린트
        PrintManager.printLadder(ladder.makeStringLadder());
        }
    }

