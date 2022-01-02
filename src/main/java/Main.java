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

        // 결과 요약 프린트
        PrintManager.printSummary(startInfo,resultInfo);
        // 결과 확인
        PrintManager.checkResult(startInfo,resultInfo);
    }}

