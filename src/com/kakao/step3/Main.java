package com.kakao.step3;

import com.kakao.step3.domain.GetInfos;
import com.kakao.step3.domain.Validator;
import com.kakao.step3.view.LadderView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LadderView ladderView = new LadderView(GetInfos.getPeopleNames(),
                GetInfos.getCountOfLines());

        ladderView.printLadder();
    }
}

