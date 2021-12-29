package com.chanminkim.w1;

import com.chanminkim.w1.controller.LadderGameDTO;
import com.chanminkim.w1.view.LadderInputView;
import com.chanminkim.w1.view.LadderOutputView;

public class Main {
    public static void main(String[] args) {
        LadderInputView inputView = new LadderInputView();
        LadderGameDTO dto = inputView.getUserInput();
        LadderOutputView outputView = new LadderOutputView(dto);
        outputView.printLadder();
    }
}
