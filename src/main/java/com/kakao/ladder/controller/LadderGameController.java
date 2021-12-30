package com.kakao.ladder.controller;

import com.kakao.ladder.model.Ladder;
import com.kakao.ladder.view.UserInput;

/**
 * author    : brody.moon
 * version   : 1.0
 * 사다리와 입력받는 함수를 연결해주는 컨트롤러입니다. MVC 패턴으로 짜보려고 도입해보았는데 많이 부족한 것 같습니다.
 */
public class LadderGameController {
    /**
     * ladder   컨트롤러에 연결된 사다리 객체입니다.
     */

    private final Ladder ladder;

    public LadderGameController() {
        ladder = new Ladder(UserInput.getInputInofs());
    }

    /**
     * 사다리 모양을 보여주고 결과에 대해 알려주는 로직을 컨트롤 하는 메서드입니다.
     */
    public void start() {
        printLadderImage();

        UserInput.bufferClear();

        resultCheck();
    }

    /**
     * 사다리 클래스에서 현재 설정된 이름들을 받아와서 UserInput 클래스로 넘겨주고 정상 입력된 문자열을 받아서 처리해주는 메서드입니다.
     */
    private void resultCheck() {
        String checkName = "";
        while (!checkName.equals(ConstStringSpace.END_CONDITION)) {
            checkName = UserInput.showResult(ladder.getNames());

            isAllOrName(checkName);
        }
    }

    /**
     * 입력된 문자열이 all 인지 춘식이 인지 특정 이름인지에 따라 따로 처리해주는 메서드입니다.
     *
     * @param name 입력된 문자열 ( 유저 이름 or all or 춘식이 )
     */
    private void isAllOrName(String name) {
        if (name.equals(ConstStringSpace.END_CONDITION))
            return;

        if (name.equals(ConstStringSpace.ALL_PRINT_CONDITION)) {
            ladder.printAllResult();
            return;
        }

        ladder.printResult(name);
    }

    /**
     * 사다리 클래스의 printLadder 메서드를 최대한 숨기기 위해 따로 메서드를 만들었습니다.
     */
    public void printLadderImage() {
        ladder.printLadder();
    }
}
