package com.kakao.util;

public class TextUtil {
    // 문자열 반복함수
    public static String makeRepeatString(String ch, int repeat) {
        String str = "";
        for(int i=0; i<repeat; i++) {
            str += ch;
        }
        return str;
    }

    // 문자열 분리함수
    public static String[] makeSplitStringArray(String ch, String regex) {
        return ch.split(regex);
    }
}
