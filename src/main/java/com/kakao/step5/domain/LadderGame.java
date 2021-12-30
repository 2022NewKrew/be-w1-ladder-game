package com.kakao.step5.domain;

import com.kakao.step5.domain.model.Ladder;
import com.kakao.step5.domain.model.Names;
import com.kakao.step5.view.LadderView;

public class LadderGame {
    public void start() {
        Names names = LadderView.askPeopleNames();

        LadderView ladderView = new LadderView(
                new Ladder(names,
                        LadderView.askResults(names.getSize()),
                        LadderView.askCountOfLines()));

        ladderView.printLadder();
        ladderView.askToFindMatchedResult();
    }
}
