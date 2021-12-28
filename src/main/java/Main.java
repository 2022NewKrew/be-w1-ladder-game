import java.text.NumberFormat;
import java.util.PrimitiveIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InputManager inputManager = new InputManager();

        // 게임인원, 사다리높이 받음
        StartInfo startInfo = inputManager.getStartInfo();

        // 사다리 랜덤 생성
        Ladder ladder = new Ladder(startInfo.getNumPeople(), startInfo.getMaxHeight());

        PrintManager printManager = new PrintManager(ladder.getLadder());

        // 사다리 프린트
        printManager.printLadder();
        }
    }

