package com.kakao.data;

// 다리 출력용 데이터 셋
public class LadderChar {
    public static final String LADDER_PREFIX = " ";
    public static final String LADDER_PILLAR = "|";
    public static final String LADDER_BRIDGE = "-";
    public static final String LADDER_SPACE = " ";
    public static final char LADDER_NEWLINE = '\n';

    // 유틸 함수
    public static String makeRepeatString(String ch, int repeat) {
        String str = "";
        for(int i=0; i<repeat; i++) {
            str += ch;
        }
        return str;
    }
}
