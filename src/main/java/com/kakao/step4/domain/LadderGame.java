package com.kakao.step4.domain;

import com.kakao.step4.domain.model.Ladder;
import com.kakao.step4.view.LadderView;

public class LadderGame {
    public void start() {
        LadderView ladderView = new LadderView(new Ladder(LadderView.askPeopleNames(),
                LadderView.askCountOfLines()));

        ladderView.printLadder();
    }
}
