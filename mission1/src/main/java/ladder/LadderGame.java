package ladder;

import ladder.domain.LadderInputManager;
import ladder.domain.LadderMaker;
import ladder.entity.LadderInfo;
import ladder.entity.LadderInput;
import ladder.view.LadderRenderer;

public class LadderGame {
    public static void main(String[] args) {
        System.out.println("사다리 게임을 시작합니다.");

        LadderInputManager ladderInputManager = new LadderInputManager();
        LadderInput ladderInput = ladderInputManager.getLadderInput();

        LadderMaker ladderMaker = new LadderMaker(ladderInput);
        LadderInfo ladderInfo = ladderMaker.getLadderInfo();

        LadderRenderer ladderRenderer = new LadderRenderer(ladderInput, ladderInfo);
        ladderRenderer.render();
    }
}