package com.cold.ladderGame.utils;

public class Pattern {
  public static final String INPUT_HEIGHT_STMT = "최대 사다리 높이는 몇 개인가요?";
  public static final String INPUT_USERS = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요):";
  public static final String INPUT_RESULT = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
  public static final String PRINT_LADDER_RESULT = "사다리 결과";
  public static final String SELECT_USER_STMT = "결과를 보고 싶은 사람은?";
  public static final String PRINT_GAME_RESULT = "실행 결과";
  public static final String PRINT_END_GAME = "게임을 종료합니다.";


  public static final int SPACE_BETWEEN_VERTICAL_LINES = 6;
  public static final int MAX_USER_NAME = 5;
  public static final int MIN_USER_NAME = 1;
  public static final int IDX_WHEN_SELECTED_ALL = -1;
  public static final String EXISTS_BRIDGE = "-----";
  public static final String NON_EXISTS_BRIDGE = "     ";
  public static final String VERTICAL_LINE = "ㅣ";

  public static final String INPUT_HEIGHT_EXCEPTION = "사다리의 높이가 1보다 작을 수는 없습니다.";
  public static final String INPUT_USERS_EXCEPTION = "이름의 길이는 1자 이상 5자 이하 이어야 합니다.";
  public static final String INPUT_RESULTS_EXCEPTION = "실행 결과와 유저의 갯수가 맞지 않습니다.";
  public static final String SELCT_USER_EXCEPTION = "존재하지 않는 유저입니다.";
}
