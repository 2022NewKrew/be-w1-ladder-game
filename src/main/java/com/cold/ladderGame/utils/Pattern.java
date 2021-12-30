package com.cold.ladderGame.utils;

public class Pattern {
  public static final String INPUT_HEIGHT_STMT = "최대 사다리 높이는 몇 개인가요?";
  public static final String INPUT_USERS = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요):";

  public static final int SPACE_BETWEEN_USERS = 6;
  public static final int MAX_USER_NAME = 5;
  public static final int MIN_USER_NAME = 1;
  public static final String EXISTS_BRIDGE = "-----";
  public static final String NON_EXISTS_BRIDGE = "     ";
  public static final String VERTICAL_LINE = "ㅣ";

  public static final String INPUT_HEIGHT_EXCEPTION = "사다리의 높이가 1보다 작을 수는 없습니다.";
  public static final String INPUT_USERS_EXCEPTION = "이름의 길이는 1자 이상 5자 이하 이어야 합니다.";
}
