package com.kakao.leo;

import java.io.IOException;

/**
 * writeManager 에 의해 실제 출력이 가능한 객체들은 Drawable 인터페이스를 상속
 *
 * @author leo.jung
 * @since 1.0
 */
public interface Drawable {

  void drawWith(WriteManager writeManager) throws IOException;

}
