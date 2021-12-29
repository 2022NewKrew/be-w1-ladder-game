package org.cs.finn.laddergame.view;

import org.cs.finn.laddergame.util.CheckBound;
import org.cs.finn.laddergame.domain.Input;

import java.util.Scanner;

public class UserInput {
    private final Input input = new Input();
    private final Scanner sc = new Scanner(System.in);

    public void closeScanner() {
        sc.close();
    }

    public void requestInput() {
        requestMember();
        requestLadderHeight();
    }

    public Input getInput() {
        return this.input;
    }

    private int requestIntBound(
            final String msg,
            final int min,
            final int max,
            final int init
    )
    {
        System.out.println(msg + " [" + min + ", " + max + "]");

        try {
            final int value = sc.nextInt(10);
            CheckBound.checkIntBound(value, min, max);
            return value;
        } catch (NullPointerException | NumberFormatException e) {
            System.out.println("잘못된 값으로 기본 값 (" + init + ")을 사용합니다");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("제한 범위[" + min + ", " + max + "]를 벗어났으므로 " + "기본 값 (" + init + ")을 사용합니다");
        }

        return init;
    }

    private void requestMember() {
        final int member = requestIntBound(
                "참여할 사람은 몇 명인가요?",
                Input.MIN_MEMBER,
                Input.MAX_MEMBER,
                Input.INIT_MEMBER
        );
        input.setMember(member);
    }

    private void requestLadderHeight() {
        final int ladderHeight = requestIntBound(
                "최대 사다리 높이는 몇 개인가요?",
                Input.MIN_LADDER_HEIGHT,
                Input.MAX_LADDER_HEIGHT,
                Input.INIT_LADDER_HEIGHT
        );
        input.setLadderHeight(ladderHeight);
    }
}
