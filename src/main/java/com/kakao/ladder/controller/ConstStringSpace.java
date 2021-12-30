package com.kakao.ladder.controller;

/**
 * author    : brody.moon
 * version   : 1.0
 * 전체 코드의 문자열을 상수로 관리하는 클래스입니다.
 */
public class ConstStringSpace {
    public static final String END_CONDITION = "춘식이";
    public static final String ALL_PRINT_CONDITION = "all";
    public static final String WHOS_RESULT = "결과를 보고 싶은 사람은?";
    public static final String INPUT_USER_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    public static final String INPUT_LADDER_RESULT_STRINGS = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    public static final String INPUT_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    public static final String INPUT_RANGE = "1 이상의 양수 값을 입력해 주세요.";
    public static final String SHOW_RESULT = "실행 결과";
    public static final String KEY_VALUE_SEPERATOR = " : ";
    public static final String LADDER_BRIDGE;
    public static final String LADDER_NONCONECT;
    public static final String SEPERATOR = ",";
    public static final int MAX_NAME_LENGTH = 5;

    /**
     * 이름의 크기를 바꾸면 자동으로 사다리의 크기를 키우기 위해 static 초기화 구문을 사용하였습니다.
     */
    static {
        LADDER_BRIDGE = "-".repeat(MAX_NAME_LENGTH);
        LADDER_NONCONECT = " ".repeat(MAX_NAME_LENGTH);
    }
}
