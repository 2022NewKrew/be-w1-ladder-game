package com.kakao.leo.view.in;

import com.kakao.leo.domain.user.Participants;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * LadderConfig 를 세팅하는 다양한 입력인터페이스 Ladder 클래스는 해당 인터페이스를 통해 LadderConfig 를 세팅받고 처리
 *
 * @author leo.jung
 * @since 1.0
 */
public interface ReadManager {

  String DELIMITER = ",";
  String INPUT_PEOPLE_MENT = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
  String INPUT_HEIGHT_MENT = "최대 사다리 높이는 몇 개인가요?";
  String WRONG_INPUT_PEOPLE_MENT = "유효한 입력값이 아닙니다. 이름과 심표를 정확하게 입력하세요.";
  String WRONG_INPUT_HEIGHT_MENT = "유효한 입력값이 아닙니다. 숫자를 입력하세요.";
  int MAX_WORD_SIZE = 5;

  Participants getParticipants() throws IOException;

  int getLadderHeight() throws IOException;

  /**
   * 입력값을 DELIMITER 로 분리 후 기본적인 값 검증 후 List 형태로 반환하는 함수. 값 검증 실패시 예외 발생.
   *
   * @param input 입력값
   * @return 입력값 스트림
   */
  default List<String> splitByDelimiter(String input) {
    List<String> splitWords = Arrays.stream(input
            .split(DELIMITER))
        .map(String::strip)
        .collect(Collectors.toList());

    checkIsValidList(splitWords);

    return splitWords;
  }

  default void checkIsValidList(List<String> words) {
    words.stream()
        .filter(word -> word.length() > MAX_WORD_SIZE)
        .findAny()
        .ifPresent(illegalWord -> {
          throw new IllegalArgumentException();
        });
  }

}

