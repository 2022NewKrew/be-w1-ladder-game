package com.kakao.leo;

import java.io.IOException;

/**
 * LadderConfig 를 세팅하는 다양한 입력인터페이스
 * Ladder 클래스는 해당 인터페이스를 통해 LadderConfig 를 세팅받고 처리
 *
 * @author leo.jung
 * @since 1.0
 */
public interface ReadManager {

  LadderConfig getOptions() throws IOException;

}
