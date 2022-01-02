import DTO.ResultInfo;
import model.Ladder;
import DTO.StartInfo;
import view.InputManager;
import view.PrintManager;

public class Main {
    public static void main(String[] args) {
        // 게임 정보 입력받음
        StartInfo startInfo = InputManager.makeStartInfo();

        // 사다리 생성
        Ladder ladder = new Ladder(startInfo.getNamePeople(), startInfo.getNumPeople(), startInfo.getMaxHeight());

        // 사다리로부터 결과 받음
        ResultInfo resultInfo = ladder.makeResultInfo();

        // 참가자 프린트
        PrintManager.printPeople(startInfo.getNamePeople());
        // 사다리 프린트
        PrintManager.printLadder(resultInfo.getStringLadder());
        System.out.println(resultInfo.getResultOrder());
    }}

