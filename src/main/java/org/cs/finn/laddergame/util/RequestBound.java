package org.cs.finn.laddergame.util;

import java.util.Scanner;

public class RequestBound {

    private RequestBound() {}

    public static int requestIntBound(
            final Scanner sc,
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
}
